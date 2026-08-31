from collections import deque
n,k=map(int,input().split())
s,s1,s2=deque(),deque(),deque()
for i in range(n):
    a,b,c=map(int,input().split())
    if(b==1)and(c==1):
        s.append(a)
    elif(b==1)and(c==0):
        s1.append(a)
    elif(b==0)and(c==1):
        s2.append(a)
x,y=0,0
sum=0
s1=deque(sorted(s1))
s2=deque(sorted(s2))
s=deque(sorted(s))
while(len(s)!=0)and(len(s1)!=0)and(len(s2)!=0):
    if(x==k)or(y==k):
        break
    if(s[0]<=s1[0]+s2[0]):
        sum=sum+s.popleft()
        
    else:
        sum=sum+s1.popleft()
        sum=sum+s2.popleft()
    x+=1
    y+=1
if(x!=k)and(y!=k)and(len(s1)==0):
    while(x!=k)and(y!=k)and(len(s)!=0):
        sum=sum+s.popleft()
        x+=1
        y+=1
if(x!=k)and(y!=k)and(len(s2)==0):
    while(x!=k)and(y!=k)and(len(s)!=0):
        sum=sum+s.popleft()
        y+=1
        x+=1
if(x!=k):
    while(len(s1)!=0)and(x!=k):
        sum=sum+s1.popleft()
        x+=1
if(y!=k):
    while(len(s2)!=0)and(y!=k):
        sum=sum+s2.popleft()
        y+=1
if(x==k)and(y==k):
    print(sum)
else:
    print(-1)
        
        
        
