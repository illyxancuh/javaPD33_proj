package com.BookHouse.Utils;

import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.BookRating;
import com.BookHouse.Domain.Genre;
import com.BookHouse.Domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

public class Patch {

    public User applyPatchToUser(
            JsonPatch patch, User targetUser) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetUser, JsonNode.class));
        return objectMapper.treeToValue(patched, User.class);
    }

    public Book applyPatchToBook(
            JsonPatch patch, Book targetBook) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetBook, JsonNode.class));
        return objectMapper.treeToValue(patched, Book.class);
    }

    public BookRating applyPatchToBookRating(
            JsonPatch patch, BookRating targetBookRating) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetBookRating, JsonNode.class));
        return objectMapper.treeToValue(patched, BookRating.class);
    }
    public Genre applyPatchToGenre(
            JsonPatch patch, Genre targetGenre) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetGenre, JsonNode.class));
        return objectMapper.treeToValue(patched, Genre.class);
    }
}
