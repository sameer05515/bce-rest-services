# Converted with pg2mysql-1.9
# Converted on Tue, 22 Aug 2017 03:04:59 -0400
# Lightbox Technologies Inc. http://www.lightbox.ca

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone="+00:00";

CREATE TABLE public.t_group
(
  id int(11) NOT NULL DEFAULT nextval('t_group_id_seq',
  creation_date timestamp NOT NULL,
  last_updation_date timestamp NOT NULL,
  description text NOT NULL,
  title text NOT NULL
)
WITH (
  OIDS=FALSE
) TYPE=MyISAM;

CREATE TABLE public.topic
(
  id int(11) NOT NULL DEFAULT nextval('topic_id_seq',
  creation_date timestamp NOT NULL,
  last_updation_date timestamp NOT NULL,
  description text NOT NULL,
  isprivate bool NOT NULL,
  title text NOT NULL
)
WITH (
  OIDS=FALSE
) TYPE=MyISAM;

CREATE TABLE public.view
(
  id int(11) NOT NULL DEFAULT nextval('view_id_seq',
  creation_date timestamp NOT NULL,
  last_updation_date timestamp NOT NULL,
  description text NOT NULL,
  title text NOT NULL
)
WITH (
  OIDS=FALSE
) TYPE=MyISAM;

CREATE TABLE public.viewtopics
(
  id int(11) NOT NULL DEFAULT nextval('viewtopics_id_seq',
  topicid int(11) NOT NULL,
  viewid int(11) NOT NULL
      REFERENCES public.topic (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      REFERENCES public.view (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
) TYPE=MyISAM;

CREATE TABLE public.topicgroups
(
  id int(11) NOT NULL DEFAULT nextval('topicgroups_id_seq',
  groupid int(11) NOT NULL,
  topicid int(11) NOT NULL
      REFERENCES public.t_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      REFERENCES public.topic (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
) TYPE=MyISAM;

CREATE TABLE public.groupviews
(
  id int(11) NOT NULL DEFAULT nextval('groupviews_id_seq',
  groupid int(11) NOT NULL,
  viewid int(11) NOT NULL
      REFERENCES public.view (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      REFERENCES public.t_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
) TYPE=MyISAM;

