package com.ilse.springBootMySql.domain.person;

import com.ilse.springBootMySql.shared.EqualByStateObject;

import javax.persistence.Embeddable;

@Embeddable
public class Inss extends EqualByStateObject {
    private String inss;

    private Inss() {}

    public Inss(String inss) {
        this.inss = inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public String getInss() {
        return inss;
    }

    public static boolean isInnsValid(String inss) {
        Long inssPart1;
        int inssCheck;
        if (inss != null && !inss.isEmpty()) {
            inssPart1 = Long.valueOf(inss.substring(0, 9));  //740529312-19
            inssCheck = Integer.parseInt(inss.substring(9));
            if ((97 - (inssPart1 % 97)) == inssCheck) {
                return true;
            } else {
                inssPart1 = Long.valueOf( "2" + inss.substring(0, 9));  //740529312-19
                inssCheck = Integer.parseInt(inss.substring(9));
                return (97 - (inssPart1 % 97)) == inssCheck;
            }
        }
        return true;
    }


}


//    Een derde groep van twee cijfers is een controlegetal op basis van de 9 voorafgaande cijfers.
//    Dat wordt berekend door het getal van negen cijfers, dat gevormd wordt door de aaneenschakeling van de geboortedatum en het reeksnummer,
//    te delen door 97. De rest van deze deling ("modulo") wordt van 97 afgetrokken. Het aldus verkregen verschil is het controlenummer.
//    Voor personen geboren in of na 2000 moet men een 2 voor het getal van negen cijfers zetten (+ 2000000000) alvorens te delen door 97.
//    Voorbeeld: Is een man geboren op 18 mei 1993, dan is een mogelijk nummer 93051822361. Immers, 930518223 gedeeld door 97 is 9592971+36.
//    Het verschil van 97 en de rest levert 97 - 36 = 61 op.