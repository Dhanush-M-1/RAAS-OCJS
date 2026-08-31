from collections import deque
n,k=map(int,input().split())
a=list(map(int,input().split()))
counted=[0 for i in range(200001)]
stored=[0 for i in range(200001)]
a.sort(reverse=True)
queue=deque()
flag=0
for i in range(n):
    stored[a[i]]+=1
    if(stored[a[i]]==k):
        print(0)
        flag=1
        break
if(flag==0):
    for i in range(n):
        queue.append([a[i],0])
    while(queue):
        num,count=queue.popleft()
        if(stored[num//2]<k):
            counted[num//2]+=count+1
            stored[num//2]+=1
        if(num//2>0):
            queue.append([num//2,count+1])
    mini=99999999
    for i in range(200001):
        if(stored[i]==k):
            mini=min(mini,counted[i])
    print(mini)