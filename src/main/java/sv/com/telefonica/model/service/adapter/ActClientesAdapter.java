package sv.com.telefonica.model.service.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import sv.com.telefonica.model.dto.ActCustomClienteDto;
import sv.com.telefonica.model.entity.ActClienteEntity;


public class ActClientesAdapter {

	public ActCustomClienteDto transformEntityToDto(ActClienteEntity entity) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		
		ActCustomClienteDto dto = new ActCustomClienteDto();
		dto.setIdCliente((entity.getId() != null) ? (entity.getId().toString()) : null);
		dto.setNombreCliente((entity.getNombreCliente() != null) ? (entity.getNombreCliente()) : "");
		dto.setTipoPersona((entity.getActTipoPersonaEntity() != null) ?(entity.getActTipoPersonaEntity().getDescripcion()) : "");
		dto.setTelefono((entity.getTelefono() != null) ? (entity.getTelefono()) : "");
		dto.setEmail((entity.getEmail() != null) ? (entity.getEmail()) : "");
		dto.setCreadoPor((entity.getCreadoPor() != null) ? (entity.getCreadoPor()) :"");	
		dto.setFechaCreado((entity.getFechaCreado() !=  null) ? dateformat.format(entity.getFechaCreado()) :"");	
		return dto;
		
	}
}
