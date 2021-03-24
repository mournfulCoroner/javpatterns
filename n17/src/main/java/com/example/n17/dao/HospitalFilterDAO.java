package com.example.n17.dao;

import com.example.n17.dto.HospitalDTO;
import com.example.n17.models.Hospital;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HospitalFilterDAO {
    @PersistenceContext
    EntityManager em;

    public List<HospitalDTO> filterByFields(String name, String address){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Hospital> cq = cb.createQuery(Hospital.class);

        Root<Hospital> proot = cq.from(Hospital.class);
        List<Predicate> preds = new ArrayList<>();

        if(name != null && !name.isEmpty()) {
            preds.add(cb.equal(proot.get("name"), name));
        }
        if(address != null && !address.isEmpty()) {
            preds.add(cb.equal(proot.get("address"), address));
        }

        cq.where(preds.toArray(new Predicate[0]));
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(Hospital h: em.createQuery(cq).getResultList()){
            HospitalDTO hospitalDTO = new HospitalDTO();
            hospitalDTO.setId(h.getId());
            hospitalDTO.setName(h.getName());
            hospitalDTO.setAddress(h.getAddress());
            hospitalDTOS.add(hospitalDTO);
        }
        return hospitalDTOS;
    }
}
