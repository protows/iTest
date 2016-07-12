package org.igov.model.subject.message;

import org.igov.model.core.EntityDao;

import java.util.List;

public interface SubjectMessageFeedbackDao extends EntityDao<Long, SubjectMessageFeedback> {

    SubjectMessageFeedback setMessage(SubjectMessageFeedback subjectMessageFeedback);

    SubjectMessageFeedback getSubjectMessageFeedbackById(Long nId);

    List<SubjectMessageFeedback> getAllSubjectMessageFeedbackBynID_Service(Long nID_service);
}
