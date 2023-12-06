package com.example.CodeLab.repository;

import com.example.CodeLab.domain.entity.CodeRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRoomRepository extends JpaRepository<CodeRoom, String> {
}
