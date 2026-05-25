package ro.sapientia.oop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sapientia.oop.repository.DictionaryRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Autowired
    private DictionaryRepository repository;

    public DictionaryServiceImpl() {}

    @Override
    public boolean findWord(String word) {
        return repository.findWord(word);
    }
}
