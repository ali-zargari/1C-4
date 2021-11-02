project folder:
ali-zargari-cs1c-project04/



Brief description of submitted files:




src/cs1c/MillionSongDataSubset.java
    - MillionSongDataSubset parses a JSON data set from a
      text file (music_genre_subset.json) and stores each entry in an array.
      It has a function to also print all the songs, and one to return a list
      of all the songs.

src/cs1c/SongEntry.java
    - One object of class SongEntry stores a simplified version of the genre data
      set from the Million Song Dataset. Has all the information relating to a song,
      like duration, name, etc.

src/cs1c/TimeConverter.java
    - Converts duration into a string representation. Used for measuring the efficiency
      of a piece of code.



src/queues/MyTunes.java
    - Object of type MyTunes simulate a playlist queue.
      Enqueues and dequeues SongEntry objects from each playlist.
      Simulates playing each song and finally checks the state of each playlist.

src/queues/Queue.java
    - Objects of type Queue manage items in a singly linked list (a playlist in our case)
      where we can enqueue items to the end and dequeue items from the front of the queue.

src/queue/Jukebox.java
    - An instance of this class may read a file which includes the user's
      requests for the name of a song to be added to a specific playlist.
    - manages three objects of type Queue<SongEntry>: favorite, roadTrip, and lounge



resources/music_genre_subset.json
    - A list of JSON objects representing different songs. Each entry has 4 items
      genre, artist_name, title, and duration. To be used by MillionSongDataSubset.java

resources/tunes.txt
    - Comma separated file for testing the project. Contains names of playlists and songs in them

resources/tunes_truncated.txt
    - Comma separated file for testing the project. Contains names of playlists and songs in them. For further testing

resources/PROOF_RUN_PROJECT_4.mp4
    - Proof that project runs with tunes_truncated.txt text file.

resources/PROOF_RUN_PROJECT_4_part2.mp4
    - Proof that project runs with tunes.txt

resources/RUN.txt
    - Text file containing example outputs with different tests, using multiple files.



README.txt
    -Description of every file.