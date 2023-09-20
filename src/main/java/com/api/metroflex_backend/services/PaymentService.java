package com.api.metroflex_backend.services;

import com.api.metroflex_backend.models.PaymentModel;
import com.api.metroflex_backend.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    IPaymentRepository paymentRepository;

    public ArrayList<PaymentModel> getPayments(){return (ArrayList<PaymentModel>) paymentRepository.findAll();}
    public PaymentModel savepayment(PaymentModel payment){return paymentRepository.save(payment);}
    public Optional<PaymentModel> getById(Long id){return paymentRepository.findById(id); }

    public PaymentModel updateById(PaymentModel request, Long id) {
        Optional<PaymentModel> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isPresent()) {
            PaymentModel payment = optionalPayment.get();

            // Verificar que los campos no sean nulos antes de actualizarlos
            if (request.getAmount() != null) {
                payment.setAmount(request.getAmount());
            }
            if (request.getDate() != null) {
                payment.setDate(request.getDate());
            }
            if (request.getMonthlySubscription() != null) {
                payment.setMonthlySubscription(request.getMonthlySubscription());
            }

            return paymentRepository.save(payment); // Guardar los cambios en la base de datos
        } else {
            // Manejar el caso en el que no se encuentre el pago con el ID dado
            throw new IllegalArgumentException("Pago no encontrado con el ID proporcionado: " + id);
        }
    }
    public Boolean deletePayment(Long id){
        try{
            paymentRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
