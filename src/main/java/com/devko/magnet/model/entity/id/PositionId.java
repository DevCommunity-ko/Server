package com.devko.magnet.model.entity.id;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PositionId implements Serializable {
	private Long positionId;
	private Long userId;
}
