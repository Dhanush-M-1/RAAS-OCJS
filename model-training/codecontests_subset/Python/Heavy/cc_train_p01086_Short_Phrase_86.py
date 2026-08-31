# coding: utf-8
while 1:
    data=[]
    for i in range(int(input())):
        data.append(len(input()))
    if len(data)==0:
        break
    for i in range(len(data)):
        j=i
        tmp=0
        while tmp<5:
            tmp+=data[j]
            j+=1
        if tmp!=5:
            continue
        tmp=0
        while tmp<7:
            tmp+=data[j]
            j+=1
        if tmp!=7:
            continue
        tmp=0
        while tmp<5:
            tmp+=data[j]
            j+=1
        if tmp!=5:
            continue
        tmp=0
        while tmp<7:
            tmp+=data[j]
            j+=1
        if tmp!=7:
            continue
        tmp=0
        while tmp<7:
            tmp+=data[j]
            j+=1
        if tmp!=7:
            continue
        print(i+1)
        break
