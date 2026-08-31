import math
t=int(input())
while(t>0):
    n=int(input())
    a=list(map(int,input().split()))
    sum1=0
    count=0
    a1=[]
    for i in a:
        a1.append(i)
    for i in a:
        if(i>0):
            sum1+=i
            count+=1
    if(count==0):
        print(0,0)
    else:
        l=[]
        count=0
        for i in range(0,n):
            if(a1[i]==-1):
                if(i+1<n):
                    if(a1[i+1]!="*" and a1[i+1]!=-1):
                        l.append(a1[i+1])
                        count+=1
                        a1[i+1]="*"
            elif(i+1<n):
                if(a1[i+1]==-1 and (a1[i]!="*" and a1[i]!=-1)):
                    l.append(a1[i])
                    count+=1
                    a1[i]=="*"
        avg=(max(l)+min(l))//2
        for i in range(0,n):
            if(a[i]==-1):
                a[i]=avg
        max1=0
        for i in range(1,n):
            d=abs(a[i]-a[i-1])
            max1=max(d,max1)
        print(max1,avg)
            
        
    t=t-1
