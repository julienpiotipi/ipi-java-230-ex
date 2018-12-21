package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        Employe e = employeRepository.findOne(3L); //fait un select avec un id égale à 3
        Iterable<Employe> e1 = employeRepository.findAll(); //fit un select * (tout)
        System.out.println(e.toString());
        System.out.println(e1.toString());

        /*Employe monEmploye = new Employe();"Julien","Piot","M12345", LocalDate.now(),3200.0);
        monEmploye= employeRepository.save(monEmploye);

        monEmploye = employeRepository.findOne(2504L);
        monEmploye.setSalaire(3420.0);
        monEmploye = employeRepository.save(monEmploye);
        employeRepository.delete(2504L);

        System.out.println(monEmploye);*/
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
