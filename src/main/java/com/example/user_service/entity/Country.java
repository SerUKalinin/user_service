package com.example.user_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Класс представляет сущность страны.
 * Эта сущность маппится на таблицу "country" в базе данных и содержит информацию о стране,
 * такую как её название и список пользователей, которые в ней проживают.
 *
 * <p>Страна связана с пользователями через отношение "один ко многим".</p>
 *
 * @author SERKALININ
 * @version 1.0
 * @since 2023-17-02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "country")
public class Country {

    /**
     * Уникальный идентификатор страны.
     * Генерируется автоматически при создании новой записи в базе данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Название страны. Должно быть уникальным и не может быть null.
     */
    @Column(name = "title", length = 64, nullable = false, unique = true)
    private String title;

    /**
     * Список пользователей, проживающих в этой стране.
     * Связь One-to-Many с сущностью {@link User}.
     */
    @OneToMany(mappedBy = "country")
    private List<User> residents;
}
