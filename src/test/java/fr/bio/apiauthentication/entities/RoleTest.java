package fr.bio.apiauthentication.entities;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Test Role JPA Entity")
@DataJpaTest
@Transactional
public class RoleTest {
    @Autowired
    private TestEntityManager entityManager;

    private Role role;

    @BeforeEach
    void setUp() {
        role = Role.builder()
                .roleName("USER")
                .build();
    }

    @AfterEach
    void tearDown() {
        role = null;
    }

    @Test
    @DisplayName("Test create role")
    public void testCreateRole() {
        Role persistedRole = entityManager.persist(role);

        assertThat(persistedRole).isNotNull();
    }

    @Test
    @DisplayName("Test update role")
    public void testUpdateRole() {
        Role newRole = role;

        newRole.setRoleName("ADMIN");
        newRole.setEnabled(false);

        Role persistedRole = entityManager.persist(newRole);

        assertThat(persistedRole).isNotNull();
    }

    @Test
    @DisplayName("Test same object")
    public void testEquals_SameObject() {
        assertThat(role).isEqualTo(role);
    }

    @Test
    @DisplayName("Test null")
    public void testEquals_Null() {
        assertThat(role).isNotEqualTo(null);
    }

    @Test
    @DisplayName("Test different class")
    public void testEquals_DifferentClass() {
        assertThat(role).isNotEqualTo("This is a different object");
    }

    @Test
    @DisplayName("Test different fields")
    public void testEquals_DifferentFields() {
        Role differentFields = Role.builder()
                .roleName("ADMIN")
                .enabled(false)
                .build();

        assertThat(role).isNotEqualTo(differentFields);
    }

    @Test
    @DisplayName("Test same fields")
    public void testEquals_SameFields() {
        Role sameFields = Role.builder()
                .roleName("USER")
                .build();

        assertThat(role).isEqualTo(sameFields);
    }

    @Test
    @DisplayName("Test same fields hashCode")
    public void testHashCode_SameFields() {
        Role sameFields = Role.builder()
                .roleName("USER")
                .build();

        assertThat(role.hashCode()).isEqualTo(sameFields.hashCode());
    }
}