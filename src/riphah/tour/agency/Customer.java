/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riphah.tour.agency;

import java.util.Arrays;

/**
 *
 * @author Qureshi Sab
 */
class Customer<T, U, E> {
    private T idArray;  // Change to a one-dimensional array
    private U nameList;
    private E additionalInfo;

    public Customer(T idArray, U nameList, E additionalInfo) {
        this.idArray = idArray;
        this.nameList = nameList;
        this.additionalInfo = additionalInfo;
    }

//    public T[] getIdArray() {
//        return idArray;
//    }
//
//    public void setIdArray(T[] idArray) {
//        this.idArray = idArray;
//    }
//
//    public U getNameList() {
//        return nameList;
//    }
//
//    public void setNameList(U nameList) {
//        this.nameList = nameList;
//    }
//
//    public E getAdditionalInfo() {
//        return additionalInfo;
//    }
//
//    public void setAdditionalInfo(E additionalInfo) {
//        this.additionalInfo = additionalInfo;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "idArray=" + idArray +
                ", nameList=" + nameList +
                ", additionalInfo=" + additionalInfo +
                '}';
    }
}