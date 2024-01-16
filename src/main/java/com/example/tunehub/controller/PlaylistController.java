package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entity.Playlist;
import com.example.tunehub.entity.Song;
import com.example.tunehub.services.PlaylistService;
import com.example.tunehub.services.SongService;

@Controller
public class PlaylistController 
{
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createPlaylist")
	public String createPlylist(Model model)
	{
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		playlistService.addPlaylist(playlist);
		
		// updating song table
		List<Song>songList=playlist.getSongs();
		for(Song s:songList)
		{
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
		}
		return"adminhome";
	}
	@GetMapping("/viewPlaylists")
	public String viewPlaylist(Model model)
	{
		List<Playlist> allPlaylists=playlistService.fetchAlllPlaylist();
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayPlaylists";
	}
}
