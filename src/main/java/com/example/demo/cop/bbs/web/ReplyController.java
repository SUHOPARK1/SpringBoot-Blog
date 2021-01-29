package com.example.demo.cop.bbs.web;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cop.bbs.service.Reply;
import com.example.demo.cop.bbs.service.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.demo.cmm.utl.Util.integer;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyRepository replyRepository;
    @PostMapping("/save")
    public Messenger save(@RequestBody Reply reply) {
        replyRepository.save(reply);
        return Messenger.SUCCESS;
    }
    @GetMapping("/count")
    public long count() {
        return replyRepository.count();
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return replyRepository.existsById(integer.apply(id));
    }
    @GetMapping("/findById/{id}")
    public Optional<Reply > findById(@PathVariable String id) {
        return replyRepository.findById(integer.apply(id));
    }
    @PostMapping("/findAll")
    public Page<Reply > findAll(@RequestBody Pageable pageable) {
        return replyRepository.findAll(pageable);
    }
    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody Reply  reply){
        replyRepository.delete(reply);
        return Messenger.SUCCESS;
    }

}
