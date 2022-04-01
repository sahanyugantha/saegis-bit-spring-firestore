package com.saegis.appone.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.saegis.appone.dao.BusDao;
import com.saegis.appone.model.Bus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class BusService {

    private static final String BUS_COLLECTION = "buses";

//    public Object getItems(){
//        BusDao busDao = new BusDao();
//        List<Bus> buses = busDao.getBuses();
//        if (buses.size() > 0){
//            return buses;
//        } else {
//            Map<String,String> message =  new HashMap<>();
//            message.put("ERROR", "No Items available");
//            return message;
//        }
//    }

    public String addItem(Bus bus) {
        try {
            Firestore db = FirestoreClient.getFirestore();
//            ApiFuture<DocumentReference> document = db.collection(BUS_COLLECTION).add(bus);
//            return document.get().getId().toString();

            ApiFuture<WriteResult> document = db.collection(BUS_COLLECTION)
                    .document(bus.getBusRegNo())
                    .set(bus);

            return document.get().getUpdateTime().toString();
        } catch (Exception e ){
            return e.getMessage();
        }
    }

    public String deleteItem(String docId){

        try {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> result = db.collection(BUS_COLLECTION)
                                            .document(docId)
                                            .delete();
            return result.get().getUpdateTime().toString();

        } catch (Exception e){
            return e.getMessage();
        }
    }


    public Object getItems(){
        try {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> query = db.collection(BUS_COLLECTION).get();
            List<QueryDocumentSnapshot> docs = query.get().getDocuments();

            List<Bus> busList = new ArrayList<>();

            for (DocumentSnapshot doc : docs){
                Bus bus = new Bus();
                bus.setId(doc.get("id").toString());
                bus.setBusRegNo(doc.get("busRegNo").toString());
                bus.setRouteNo(doc.get("routeNo").toString());

                busList.add(bus);
            }

            return busList;

        } catch (Exception e){
            e.printStackTrace();
            Map<String,String> errMsg = new HashMap<>();
            errMsg.put("ERROR", e.getMessage());
            return null;
        }
    }

}
