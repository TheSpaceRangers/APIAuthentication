package fr.bio.apiauthentication.services.interfaces;

import fr.bio.apiauthentication.dto.MessageResponse;
import fr.bio.apiauthentication.dto.admin.RoleModificationRequest;
import fr.bio.apiauthentication.dto.admin.RoleStructureResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAdminRoleService {
    ResponseEntity<List<RoleStructureResponse>> getAllRolesByStatus(String token, Boolean isActive);

    ResponseEntity<MessageResponse> createRole(String token, RoleModificationRequest request);

    ResponseEntity<MessageResponse> updateRole(String token, RoleModificationRequest request);

    ResponseEntity<MessageResponse> updateRoleStatus(String token, RoleModificationRequest request, boolean status);
}