import bisect
import math
for _ in range(int(input())):
    n,m=map(int,input().split())
    lis=list(map(int,input().split()))
    x=list(map(int,input().split()))
    prefix=[]
    dic={}
    sum1=0
    for i in range(len(lis)):
        sum1+=lis[i] 
        if prefix and sum1<prefix[-1]:
            continue
        prefix.append(sum1)
        if sum1 not in dic:
            dic[sum1]=i 

    l2=[]
    for i in range(len(prefix)):
        l2.append(prefix[i])
        
            
    l2.sort()
    output=[]
    for i in x:
        if lis[0]>=i:
            output.append(0)
            continue
        if l2[-1]<i and sum1<=0:
            output.append(-1)
            continue
        if sum1>0 and l2[-1]<i:
            temp = i-l2[-1]
            rotations=math.ceil(temp/sum1)
            find=i-rotations*sum1 
           
            output.append(len(lis)*rotations+dic[l2[bisect.bisect_left(l2,find)]])
            continue 
        if l2[-1]>=i:
            
            output.append(dic[l2[bisect.bisect_left(l2,i)]]) 
    for i in output:
        print(i,end=" ")
    print()

    
