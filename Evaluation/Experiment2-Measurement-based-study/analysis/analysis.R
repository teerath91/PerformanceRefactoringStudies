library(splitstackshape)
library(plyr)
library(vioplot)
library(effsize)
library(sm)
library(scales)
library(survival)
library(MASS)
library(fitdistrplus)
install.packages("raster")
library(raster)

filenames <- c(
  "drawallocation",
  "afterdrawallocation",
  "handlerleak",
  "afterhandlerleak",
  "recycle",
  "afterrecycle",
  "usesparsearrays",
  "afterusesparsearrays",
  "usevalueof",
  "afterusevalueof",
  "viewholder",
  "afterviewholder"
)


for(i in 1:length(filenames)) {
  assign(paste('x_', filenames[i], sep=''), read.csv(paste("./", filenames[i], ".csv", sep = ""), sep=",", header=T, row.names=NULL, stringsAsFactors=FALSE))
}

pdf(paste("./", "cpuanalysis", ".pdf", sep=""), width=10)
par(mar=c(8, 8, 5, 5))

labels <- c("DrawAllocationNonRef", "DrawAllocationRef", "HandlerLeakNonRef", "HandlerLeakRef", "RecycleNONRef", "RecycleRef", "UseSparseArraysNonRef", "UseSparseArraysRef", "UseValueOfNonRef", "UseValueOfRef", "ViewHolderNonRef", "ViewHolderRef")
par(las=2)
p <- boxplot(x_drawallocation$cpu,
               x_afterdrawallocation$cpu,
               x_handlerleak$cpu,
               x_afterhandlerleak$cpu,
               x_recycle$cpu,
               x_afterrecycle$cpu,
               x_usesparsearrays$cpu,
               x_afterusesparsearrays$cpu,
               x_usevalueof$cpu,
               x_afterusevalueof$cpu,
               x_viewholder$cpu,
               x_afterviewholder$cpu,
               names=labels, col="grey", drawRect=TRUE, wex=0.5, range=1, cex.axis=0.75)
  abline(v=2.5)
  abline(v=4.5)
  abline(v=6.5)
  abline(v=8.5)
  abline(v=10.5)
  
dev.off()


pdf(paste("./", "memoryanalysis", ".pdf", sep=""), width=10)
par(mar=c(8, 8, 5, 5))

labels <- c("DrawAllocationNonRef", "DrawAllocationRef", "HandlerLeakNonRef", "HandlerLeakRef", "RecycleNONRef", "RecycleRef", "UseSparseArraysNonRef", "UseSparseArraysRef", "UseValueOfNonRef", "UseValueOfRef", "ViewHolderNonRef", "ViewHolderRef")
par(las=2)
p <- boxplot(x_drawallocation$mem / 1024,
             x_afterdrawallocation$mem / 1024,
             x_handlerleak$mem / 1024,
             x_afterhandlerleak$mem / 1024,
             x_recycle$mem / 1024,
             x_afterrecycle$mem / 1024,
             x_usesparsearrays$mem / 1024,
             x_afterusesparsearrays$mem / 1024,
             x_usevalueof$mem / 1024,
             x_afterusevalueof$mem / 1024,
             x_viewholder$mem / 1024,
             x_afterviewholder$mem / 1024,
             names=labels, col="grey", drawRect=TRUE, wex=0.5, range=1,ylim=c(0,60), cex.axis=0.75)
abline(v=2.5)
abline(v=4.5)
abline(v=6.5)
abline(v=8.5)
abline(v=10.5)

dev.off()


check_p_values_cpu <- function() {
  print(paste0("DA"))
  print(wilcox.test(x_drawallocation$cpu,x_afterdrawallocation$cpu, correct=FALSE))
  print(paste0("HL"))
  print(wilcox.test(x_handlerleak$cpu,x_afterhandlerleak$cpu, correct=FALSE)$p.value)
  print(paste0("RC"))
  print(wilcox.test(x_recycle$cpu,x_afterrecycle$cpu, correct=FALSE)$p.value)
  print(paste0("USA"))
  print(wilcox.test(x_usesparsearrays$cpu,x_afterusesparsearrays$cpu, correct=FALSE)$p.value)
  print(paste0("UVO"))
  print(wilcox.test(x_usevalueof$cpu,x_afterusevalueof$cpu, correct=FALSE)$p.value)
  print(paste0("VH"))
  print(wilcox.test(x_viewholder$cpu,x_afterviewholder$cpu, correct=FALSE)$p.value)
}

check_cliffdelta_values_cpu <- function() {
  print(paste0("DA"))
  print(cliff.delta(x_drawallocation$cpu,x_afterdrawallocation$cpu))
  print(paste0("HL"))
  print(cliff.delta(x_handlerleak$cpu,x_afterhandlerleak$cpu))
  print(paste0("RC"))
  print(cliff.delta(x_recycle$cpu,x_afterrecycle$cpu))
  print(paste0("USA"))
  print(cliff.delta(x_usesparsearrays$cpu,x_afterusesparsearrays$cpu))
  print(paste0("UVO"))
  print(cliff.delta(x_usevalueof$cpu,x_afterusevalueof$cpu))
  print(paste0("VH"))
  print(cliff.delta(x_viewholder$cpu,x_afterviewholder$cpu))
}


check_p_values_mem <- function() {
  print(wilcox.test(x_drawallocation$mem,x_afterdrawallocation$mem, correction=F)$p.value)
  print(wilcox.test(x_handlerleak$mem,x_afterhandlerleak$mem, correction=F)$p.value)
  print(wilcox.test(x_recycle$mem,x_afterrecycle$mem, correction=F)$p.value)
  print(wilcox.test(x_usesparsearrays$mem,x_afterusesparsearrays$mem, correction=F)$p.value)
  print(wilcox.test(x_usevalueof$mem,x_afterusevalueof$mem, correction=F)$p.value)
  print(wilcox.test(x_viewholder$mem,x_afterviewholder$mem, correction=F)$p.value)
}

check_cliffdelta_values_mem <- function() {
  print(cliff.delta(x_drawallocation$mem,x_afterdrawallocation$mem))
  print(cliff.delta(x_handlerleak$mem,x_afterhandlerleak$mem))
  print(cliff.delta(x_recycle$mem,x_afterrecycle$mem))
  print(cliff.delta(x_usesparsearrays$mem,x_afterusesparsearrays$mem))
  print(cliff.delta(x_usevalueof$mem,x_afterusevalueof$mem))
  print(cliff.delta(x_viewholder$mem,x_afterviewholder$mem))
}

check_cliffdelta1_values_mem <- function() {
  print(cliff.delta(x_drawallocation$mem / 1024,x_afterdrawallocation$mem / 1024))
  print(cliff.delta(x_handlerleak$mem / 1024,x_afterhandlerleak$mem / 1024))
  print(cliff.delta(x_recycle$mem / 1024,x_afterrecycle$mem / 1024))
  print(cliff.delta(x_usesparsearrays$mem / 1024,x_afterusesparsearrays$mem / 1024))
  print(cliff.delta(x_usevalueof$mem / 1024,x_afterusevalueof$mem / 1024))
  print(cliff.delta(x_viewholder$mem / 1024,x_afterviewholder$mem / 1024))
}


check_descriptive_values_cpu <- function() {
  filenames <- c(
    "drawallocation",
    "afterdrawallocation",
    "handlerleak",
    "afterhandlerleak",
    "recycle",
    "afterrecycle",
    "usesparsearrays",
    "afterusesparsearrays",
    "usevalueof",
    "afterusevalueof",
    "viewholder",
    "afterviewholder"
  )
  
  
  for(i in 1:length(filenames)) {
    details <- assign(paste('x_', filenames[i], sep=''), read.csv(paste("./", filenames[i], ".csv", sep = ""), sep=",", header=T, row.names=NULL, stringsAsFactors=FALSE))
    print(paste("Statistic for issue type", filenames[i]))
    Minn <- min(details$cpu)
    Maxx <- max(details$cpu)
    Mediann <- median(details$cpu)
    Meann <- mean(details$cpu)
    SDD <- sd(details$cpu)
    CVV <- cv(details$cpu)
    print(paste("Minimum is", Minn))
    print(paste("Maximum is", Maxx))
    print(paste("Median is", Mediann))
    print(paste("Mean is", Meann))
    print(paste("Standard Deviation is", SDD))
    print(paste("Coefficient of variant is", CVV))
  }
}



# Descriptive analysis memory consumption

check_descriptive_values_mem<- function() {
  filenames <- c(
    "drawallocation",
    "afterdrawallocation",
    "handlerleak",
    "afterhandlerleak",
    "recycle",
    "afterrecycle",
    "usesparsearrays",
    "afterusesparsearrays",
    "usevalueof",
    "afterusevalueof",
    "viewholder",
    "afterviewholder"
  )
  
  
  for(i in 1:length(filenames)) {
    details <- assign(paste('x_', filenames[i], sep=''), read.csv(paste("./", filenames[i], ".csv", sep = ""), sep=",", header=T, row.names=NULL, stringsAsFactors=FALSE))
    print(paste("Statistic for issue type", filenames[i]))
    Minn <- min(details$mem / 1024)
    Maxx <- max(details$mem / 1024)
    Mediann <- median(details$mem / 1024)
    Meann <- mean(details$mem / 1024)
    SDD <- sd(details$mem / 1024)
    CVV <- cv(details$mem / 1024)
    print(paste("Minimum is", Minn))
    print(paste("Maximum is", Maxx))
    print(paste("Median is", Mediann))
    print(paste("Mean is", Meann))
    print(paste("Standard Deviation is", SDD))
    print(paste("Coefficient of variant is", CVV))
  }
}


#analysis()

print(paste0("CPU Values"))

check_p_values_cpu()

print(paste0("Cliff Delta CPU Values"))

check_cliffdelta_values_cpu()


print(paste0("Memory Values"))

check_p_values_mem()


print(paste0("Cliff Delta Memory Values"))

check_cliffdelta_values_mem()

#print(paste0("Cliff Delta 1024 Memory Values"))

#check_cliffdelta1_values_mem()

print(paste0("Descriptive CPU Values"))

check_descriptive_values_cpu()

print(paste0("Descriptive Memory Values"))

check_descriptive_values_mem()

#print(summary(x_viewholder$mem / 1024))
#print(summary(x_afterviewholder$mem / 1024))