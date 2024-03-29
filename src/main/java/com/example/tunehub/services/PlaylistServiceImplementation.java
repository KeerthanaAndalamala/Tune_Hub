package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entity.Playlist;
import com.example.tunehub.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService 
{
	@Autowired
	PlaylistRepository repo;

	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAlllPlaylist() {
		return repo.findAll();
	}

}
