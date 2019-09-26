library(likert)
library(reshape)

#CodeExecution


dataexection<-read.csv("./Execution-responses.csv",sep=",")

#attach(t)0

#Ordering levels
mylevels1 <- c("Strongly disagree", "Disagree", "Don't know", "Neither agree nor disagree", "Agree", "Strongly agree")

#Applying levels in the desired order and excluding don't know data
s1 <- as.data.frame(lapply(dataexection,function(x) {factor(x,levels=mylevels1,exclude="Don't know")}))
pdf(paste("./", "codeExecution_Q11", ".pdf", sep=""), width=16)
#Putting data in the Likert format
l1=likert(s1)

#Plotting
plot(l1)
dev.off()

#CodeComprehension


datacomprehension<-read.csv("./Comprehension-responses.csv",sep=",")

#attach(t)0

#Ordering levels
mylevels2 <- c("Strongly disagree", "Disagree", "Don't know", "Neither agree nor disagree", "Agree", "Strongly agree")

#Applying levels in the desired order and excluding don't know data
s2 <- as.data.frame(lapply(datacomprehension,function(x) {factor(x,levels=mylevels2,exclude="Don't know")}))
pdf(paste("./", "codeComprehensive_Q2", ".pdf", sep=""), width=16)
#Putting data in the Likert format
l2=likert(s2)

#Plotting
plot(l2)
dev.off()
