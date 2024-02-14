package com.example.policyadministrativesystem.controller;

import com.example.policyadministrativesystem.entity.Coverage;
import com.example.policyadministrativesystem.entity.Policy;
import com.example.policyadministrativesystem.entity.Rate;
import com.example.policyadministrativesystem.entity.State;
import com.example.policyadministrativesystem.service.CoverageServiceImpl;
import com.example.policyadministrativesystem.service.PolicyServiceImpl;
import com.example.policyadministrativesystem.service.RateServiceImpl;
import com.example.policyadministrativesystem.service.StateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyServiceImpl policyService;
    @Autowired
    private CoverageServiceImpl coverageService;
    @Autowired
    private StateServiceImpl stateService;
    @Autowired
    private RateServiceImpl rateService;

    private Policy currentPolicy = new Policy();
    private List<Coverage> currentCoverage = new ArrayList<Coverage>();
    public String currentStateID;
    private int premiumAmount;
    private Policy updatePolicy ;

    @GetMapping("/list")
    public String getAllPolicys(Model model) {
        model.addAttribute("policys", policyService.getAll());
        return "list-policy";
    }

    @GetMapping("/add")
    public String addPolicy(Model model) {
        model.addAttribute("policy", new Policy());

        return "add-policy";
    }

    @PostMapping("/save")
    public String addCoverage(@ModelAttribute("policy") Policy policy,  Model  model) {
        currentPolicy.setPolicyNo(policy.getPolicyNo());
        currentPolicy.setPolicyHolderName(policy.getPolicyHolderName());
        currentPolicy.setAddressline1(policy.getAddressline1());
        currentPolicy.setAddressline2(policy.getAddressline2());

        policyService.storePolicy(currentPolicy);
        return "redirect:/policy/covs";
    }

     @GetMapping("/covs")
     public String addCovs(Model model) {

         model.addAttribute("states", stateService.getAllStates());
         model.addAttribute("coverages", coverageService.getAllCoverages());

         return "add-coverage";
     }
    @PostMapping("/addCoverage")
    public String getCoverage(@RequestParam("covs") String[] coverageIDs, @RequestParam("state") String sid, Model model) {
        currentStateID=sid;

        for(String c: coverageIDs) {
            Coverage coverage = coverageService.getCoverage(Integer.parseInt(c));
                currentCoverage.add(coverage);
        }

        int amount=0;

        for(String c: coverageIDs) {
            Coverage coverage = coverageService.getCoverage(Integer.parseInt(c));
            State state = stateService.getState(Integer.parseInt(sid));
            Rate rate = rateService.getRate(coverage.getCoverageName(),state.getStateName());
            amount = amount + rate.getRate();
        }

        model.addAttribute("preminum",amount);
        currentPolicy.setPreminumAmount(amount);
        State state = stateService.getState(Integer.parseInt(sid));
        currentPolicy.setState(state);
        currentPolicy.setCoverages(currentCoverage);
        currentCoverage = new ArrayList<Coverage>();
        policyService.storePolicy(currentPolicy);
        return "show-premium";
    }

    @GetMapping("/store")
    public String saveData(Model model) {
        currentPolicy.setStatus("Bound");
        policyService.storePolicy(currentPolicy);
        model.addAttribute("policy",currentPolicy);
        currentPolicy = new Policy();

        return "view-policy";
    }

    @GetMapping("/update")
    public String updateData(@RequestParam("pid") int id,Model model) {
        updatePolicy = policyService.getPolicy(id);
        model.addAttribute("policy", policyService.getPolicy(id));
        return "update";
    }

    @PostMapping("/updatePolicyinfo")
    public String updatePolicyinfo(@ModelAttribute("policy") Policy policy, Model model) {

        currentPolicy.setPolicyNo(policy.getPolicyNo());
        currentPolicy.setPolicyHolderName(policy.getPolicyHolderName());
        currentPolicy.setAddressline1(policy.getAddressline1());
        currentPolicy.setAddressline2(policy.getAddressline2());
        policyService.storePolicy(currentPolicy);
        model.addAttribute("policy", updatePolicy);
        model.addAttribute("states", stateService.getAllStates());

        return "update-state";
    }

    @PostMapping("/updateState")
    public String updateCoverage( @RequestParam("state") String sid,Model model) {
        currentStateID=sid;

        State state = stateService.getState(Integer.parseInt(currentStateID));
        currentPolicy.setState(state);
        policyService.storePolicy(currentPolicy);

        model.addAttribute("cos", updatePolicy.getCoverages());
        model.addAttribute("coverages", coverageService.getAllCoverages());
        return "update-coverage";
    }

    @GetMapping("/upCoverage")
    public String upCoverage(Model model,@RequestParam("covs") String[] coverageIDs) {

        return null;
    }

    @GetMapping("/updatedPolicy")
    public String finalUpdate() {
        currentPolicy.setStatus("Bound");
        policyService.storePolicy(currentPolicy);
        currentPolicy = new Policy();
        return "redirect:/policy/list";
    }
}
