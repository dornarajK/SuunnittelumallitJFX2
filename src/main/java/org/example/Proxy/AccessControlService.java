package org.example.Proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;



public class AccessControlService {

    // one shared instance (Sigletion)
    private static final AccessControlService instance =
            new AccessControlService();


    // store document id and allowed users
    private Map<Integer, Set<String>> permissions =
            new HashMap<>();


    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return instance;
    }

    // Give a user permission to access a document
    public void grantAccess(int documentId, String username) {
        permissions
                .computeIfAbsent(documentId, id -> new HashSet<>())
                .add(username);
    }

    // check if a user has permission to access a document
    public boolean isAllowed(int documentId, String username) {
        return permissions.containsKey(documentId)
                && permissions.get(documentId).contains(username);
    }

}
