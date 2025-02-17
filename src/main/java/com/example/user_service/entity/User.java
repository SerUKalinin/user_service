package com.example.user_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;
import java.util.List;

/**
 * Класс представляет сущность пользователя в системе.
 * Эта сущность маппится на таблицу "users" в базе данных и содержит информацию о пользователе,
 * такую как имя, электронная почта, пароль, контактные данные, местоположение и другие атрибуты.
 *
 * <p>Пользователь может иметь связи с другими сущностями, такими как страна, события, цели и другие пользователи.</p>
 *
 * @author SERKALININ
 * @version 1.0
 * @since 2023-17-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /**
     * Уникальный идентификатор пользователя.
     * Генерируется автоматически при создании новой записи в базе данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя пользователя. Должно быть уникальным и не может быть null.
     */
    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;

    /**
     * Электронная почта пользователя. Должна быть уникальной и не может быть null.
     */
    @Column(name = "email", length = 64, nullable = false, unique = true)
    private String email;

    /**
     * Номер телефона пользователя. Должен быть уникальным.
     */
    @Column(name = "phone", length = 32, unique = true)
    private String phone;

    /**
     * Идентификатор пользователя в Telegram. Должен быть уникальным.
     */
    @Column(name = "telegram_id", length = 32, unique = true)
    private String telegramId;

    /**
     * Пароль пользователя. Не может быть null.
     */
    @Column(name = "password", length = 128, nullable = false)
    private String password;

    /**
     * Флаг, указывающий, активен ли пользователь. По умолчанию true.
     */
    @Column(name = "active", nullable = false)
    private boolean active = true;

    /**
     * Информация о пользователе. Может содержать до 4096 символов.
     */
    @Column(name = "about_me", length = 4096)
    private String aboutMe;

    /**
     * Страна, в которой проживает пользователь.
     * Связь Many-to-One с сущностью {@link Country}.
     */
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    /**
     * Город, в котором проживает пользователь.
     */
    @Column(name = "city", length = 64)
    private String city;

    /**
     * Опыт пользователя. Может быть null, если не указан.
     */
    @Column(name = "experience")
    private Integer experience;

    /**
     * Дата и время создания записи пользователя.
     * Заполняется автоматически при создании записи.
     */
    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    /**
     * Дата и время последнего обновления записи пользователя.
     * Заполняется автоматически при обновлении записи.
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    /**
     * Список пользователей, на которых подписан текущий пользователь.
     * Связь Many-to-Many с сущностью {@link User}.
     */
    @ManyToMany(mappedBy = "followers")
    private List<User> followees;
}
