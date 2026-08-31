s=input()
s1=s.split()

n=int(s1[0])
k=int(s1[1])

import heapq

heap1=[]
heap2=[]
heap3=[]

heapq.heapify(heap1)
heapq.heapify(heap2)
heapq.heapify(heap3)

for i in range(n):

    s=input()

    s1=s.split()

    if int(s1[1])==0 and int(s1[2])==1:

        heapq.heappush(heap1,int(s1[0]))


    if int(s1[1])==1 and int(s1[2])==0:

        heapq.heappush(heap2,int(s1[0]))


    if int(s1[1])==1 and int(s1[2])==1:

        heapq.heappush(heap3,int(s1[0]))

sum1=0
while ((heap1 and heap2) or heap3) and k>0:

    
    if heap1 and heap2:
        c1=heapq.heappop(heap1)
        c2=heapq.heappop(heap2)
    else:
        c1=1e10
        c2=1e10

    if heap3:
        
    
        c3=heapq.heappop(heap3)
    else:
        c3=1e10
   
    if c3<(c2+c1):

        sum1=sum1+c3
        if c1!=1e10:
            heapq.heappush(heap1,c1)
        if c2!=1e10:
            heapq.heappush(heap2,c2)
    else:
        
        sum1=sum1+c2+c1
        if c3!=1e10:
            heapq.heappush(heap3,c3)

    k=k-1
    
if k>0:
    print(-1)
else:
    print(sum1)




















