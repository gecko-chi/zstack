package org.zstack.header.core.scheduler;

import org.zstack.header.configuration.PythonClassInventory;
import org.zstack.header.rest.APINoSee;
import org.zstack.header.search.Inventory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by root on 7/18/16.
 */
@Inventory(mappingVOClass = SchedulerJobVO.class, collectionValueOfMethod = "valueOf1")
@PythonClassInventory
public class SchedulerJobInventory implements Serializable {
    private String uuid;
    private String targetResourceUuid;
    private String name;
    private String description;
    private Timestamp createDate;
    private Timestamp lastOpDate;
    /**
     * @desc jobClassName define the job
     */
    @APINoSee
    private String jobData;
    @APINoSee
    private String jobName;

    protected SchedulerJobInventory(SchedulerJobVO vo) {
        uuid = vo.getUuid();
        name = vo.getName();
        description = vo.getDescription();
        targetResourceUuid = vo.getTargetResourceUuid();
        createDate = vo.getCreateDate();
        lastOpDate = vo.getLastOpDate();
        jobData = vo.getJobData();
        jobName = vo.getJobName();
    }

    public SchedulerJobInventory() {

    }

    public static SchedulerJobInventory valueOf(SchedulerJobVO vo) {
        return new SchedulerJobInventory(vo);
    }

    public static List<SchedulerJobInventory> valueOf1(Collection<SchedulerJobVO> vos) {
        List<SchedulerJobInventory> invs = new ArrayList<SchedulerJobInventory>(vos.size());
        for (SchedulerJobVO vo : vos) {
            invs.add(SchedulerJobInventory.valueOf(vo));
        }
        return invs;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastOpDate() {
        return lastOpDate;
    }

    public void setLastOpDate(Timestamp lastOpDate) {
        this.lastOpDate = lastOpDate;
    }

    public String getJobData() {
        return jobData;
    }

    public void setJobData(String jobData) {
        this.jobData = jobData;
    }

    public String getTargetResourceUuid() {
        return targetResourceUuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setTargetResourceUuid(String targetResourceUuid) {
        this.targetResourceUuid = targetResourceUuid;
    }
}
