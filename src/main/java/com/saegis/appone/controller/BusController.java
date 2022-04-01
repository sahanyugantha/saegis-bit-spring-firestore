package com.saegis.appone.controller;

import com.saegis.appone.model.Bus;
import com.saegis.appone.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    private BusService busService = new BusService();


    /**
     *
     * @return
     */
    @GetMapping
    public Object getBuses(){
        return busService.getItems();
    }

    @PostMapping
    public String addBus(@RequestBody Bus bus){
        return busService.addItem(bus);
    }

    @DeleteMapping("/{docId}")
    public String deleteBus(@PathVariable("docId") String docId){
       return busService.deleteItem(docId);
    }

   

}
