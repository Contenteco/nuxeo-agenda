package org.nuxeo.ecm.agenda;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentModelList;

/**
 * @author <a href="mailto:akervern@nuxeo.com">Arnaud Kervern</a>
 * @since 5.6
 */
public interface AgendaService {
    /**
     * List user readable agendum between both date
     * 
     * @param path
     * @param dtStart the start date
     * @param dtEnd the end date (included)
     * @return matching Event as a DocumentModelList object
     */
    DocumentModelList listEvents(CoreSession session, String path, Date dtStart, Date dtEnd) throws ClientException;

    /**
     * List incoming user readable agendum with a limit
     * 
     * @param path
     * @param limit the number of events returned must be greater than 0 otherwise ClientException is thrown
     * @return matching Event as a DocumentModelList object
     */
    DocumentModelList listEvents(CoreSession session, String path, int limit) throws ClientException;

    /**
     * Create a new Event document to the specific path. If the path is blank or "/", the new event will be created into
     * the UserWorkspace
     * 
     * @param sesion CoreSession used to create the new doc
     * @param path base path, if it is blank or "/"; the new event will be created into the UserWorkspace
     * @param properties corresponding metadata
     * @return a new Event created
     */
    DocumentModel createEvent(CoreSession session, String path, Map<String, Serializable> properties)
            throws ClientException;
}
