package com.electrics.ejb_jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author duncan
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode",
                                  propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "ecleticsQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class electics_mdb implements MessageListener {
    Dao dao=null;
    public electics_mdb() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = null;
            msg = (TextMessage) message;
            dao=new Dao();
            String userName=dao.getUserName(Integer.parseInt(msg.getText()));
            System.out.println("Electrics got user user" + userName);
        } catch (JMSException ex) {
            Logger.getLogger(electics_mdb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
