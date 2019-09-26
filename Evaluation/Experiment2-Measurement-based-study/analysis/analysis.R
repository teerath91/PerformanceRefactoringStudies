library(likert)
library(reshape)


datameasure<-read.csv("./Aggregated_Results_Android.csv",sep=",")
AppType <- datameasure$Category


pdf(paste("./", "cpuanalysis", ".pdf", sep=""), width=13)
cpuanalysis <- ggplot(data=datameasure, aes(x=datameasure$IssueName, y=datameasure$android_cpu, fill=AppType)) +
  geom_bar(stat="identity", position=position_dodge())+
  geom_text(aes(label=datameasure$android_cpu), vjust=1.6, #color="white",
                  position = position_dodge(0.9), size=3.0)+
  labs(x="Type of Issue", y = "CPU (%)")+ 
  scale_y_continuous(limits = c(0, 25)) +
  #scale_fill_brewer(palette="Paired") +
  scale_fill_brewer(palette="Greens") +
  #scale_fill_manual(values=c('lightpink','pink')) +
  theme_minimal() + theme(text = element_text(size=16), axis.text.x = element_text(angle = 90, hjust = 1))

plot(cpuanalysis)
dev.off()

pdf(paste("./", "memoryanalysis", ".pdf", sep=""), width=13)
cpuanalysis <- ggplot(data=datameasure, aes(x=datameasure$IssueName, y=datameasure$android_mem, fill=AppType)) +
  geom_bar(stat="identity", position=position_dodge())+
  geom_text(aes(label=datameasure$android_mem), vjust=1.6, #color="white",
            position = position_dodge(0.9), size=3.0)+
  labs(x="Type of Issue", y = "Memory Consumption (KB)")+
  scale_y_continuous(limits = c(0, 35000)) +
  scale_fill_brewer(palette="Reds") +
  #scale_fill_manual(values=c('black','lightgray')) +
  theme_minimal() + theme(text = element_text(size=16), axis.text.x = element_text(angle = 90, hjust = 1))

plot(cpuanalysis)
dev.off()