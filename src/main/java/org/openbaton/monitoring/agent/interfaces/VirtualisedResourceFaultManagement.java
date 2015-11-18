package org.openbaton.monitoring.agent.interfaces;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.openbaton.monitoring.agent.alarm.catalogue.AbstractVirtualizedResourceAlarm;
import org.openbaton.monitoring.agent.alarm.catalogue.Alarm;
import org.openbaton.monitoring.agent.alarm.catalogue.AlarmEndpoint;
import org.openbaton.monitoring.agent.alarm.catalogue.PerceivedSeverity;

import java.util.List;

/**
 * Created by mob on 15.11.15.
 */
public interface VirtualisedResourceFaultManagement {
    /*
    * This operation enables the NFVO to subscribe for notifications
    * related to the alarms and their state changes resulting from the
    * virtualised resources faults with the VIM. This also enables the NFVO
    * to specify the scope of the subscription in terms of the specific
    * alarms for the virtualised resources to be reported by the VIM using a filter as the input. 
    * */
    String subscribe(AlarmEndpoint filter);
    void unsubscribe(String alarmEndpointId);
    /*
    * This operation distributes notifications to subscribers.
    * It is a one-way operation issued by the VIM that cannot
    * be invoked as an operation by the consumer (NFVO). 
    * The following notifications can be published/notified/sent by this operation:  
    *   - AlarmNotification  (VirtualizedResourceAlarmNotification)
    *   - AlarmStateChangedNotification  (VirtualizedResourceAlarmStateChangedNotification)
    */
    void notifyFault(AlarmEndpoint endpoint, AbstractVirtualizedResourceAlarm event) throws UnirestException;
    /*
    * This operation enables the NFVOs to query for active alarms from the VIM. 
    */
    List<Alarm> getAlarmList(String vnfId, PerceivedSeverity perceivedSeverity);
}
