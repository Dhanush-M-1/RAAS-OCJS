from collections import deque
n,k=map(int,input().split())
s,s1,s2=deque(),deque(),deque()
while(n):
  t,a,b=map(int,input().split())
  if(a==1 and b==1):
    s.append(t)
  if(a==1 and b==0):
    s1.append(t)
  if(a==0 and b==1):
    s2.append(t)
  n-=1
s=deque(sorted(s))
s1=deque(sorted(s1))
s2=deque(sorted(s2))
x,y,t=0,0,0
while(len(s) and len(s1) and len(s2)):
  if(x==k or y==k):
    break
  if(s[0]<s1[0]+s2[0]):
    x+=1
    y+=1
    t+=s[0]
    s.popleft()
  else:
    t+=s1[0]+s2[0]
    x+=1
    y+=1
    s1.popleft()
    s2.popleft()
if(x!=k and y!=k and len(s1)==0):
  while (x!=k and y!=k and len(s)!=0):
    x+=1
    y+=1
    t+=s[0]
    s.popleft()
if(x!=k and y!=k and len(s2)==0):
  while (x!=k and y!=k and len(s)!=0):
    x+=1
    y+=1
    t+=s[0]
    s.popleft()
if(x!=k):
  while(len(s1) and x!=k):
    t+=s1[0]
    s1.popleft()
    x+=1
if(y!=k):
  while (len(s2) and y!=k):
    t+=s2[0]
    s2.popleft()
    y+=1
if(x==k and y==k):
  print(t)
else:
  print("-1")