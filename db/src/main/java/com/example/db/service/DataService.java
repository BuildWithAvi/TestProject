package com.example.db.service;

import com.example.db.dto.DataRequest;

public interface DataService {
    /**
     * Save data to the appropriate database based on the input.
     *
     * @param request The DataRequest object containing input fields.
     * @return A success message indicating which database was used.
     */
    String saveData(DataRequest request);
}