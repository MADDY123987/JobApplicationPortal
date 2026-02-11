package com.embarkx.jobms.job;

import com.embarkx.jobms.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    private List<Job> jobs = new ArrayList<>();

    @GetMapping
    public List<JobDTO> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job Added Succefully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobDTO =  jobService.getJobById(id);
        if(jobDTO !=null)
        {
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id)
    {
        boolean deleted=jobService.deleteJobById(id);
        if(deleted)
        {
            return new ResponseEntity<>("Job delete Succesfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    //@RequestMapping(value = "/jobs/{id]" ,method=RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob)
    {
         boolean updated=jobService.updateJob(id,updatedJob);
         if(updated)
         {
             return new ResponseEntity<>("job updated Succesfully",HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
