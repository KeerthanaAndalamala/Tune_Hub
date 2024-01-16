package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entity.Playlist;

public interface PlaylistService 
{
	public void addPlaylist(Playlist playlist);
	public List<Playlist> fetchAlllPlaylist();

}
