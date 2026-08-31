n,k = [int(i) for i in input().split()]

l = []

for i in range(n):
    x = [int(i) for i in input().split()]
    l.append(x)

l.sort(key = lambda x:x[0])
#print(l)
from heapq import heappop,heappush

a = []
b = []
ans = 0

ak = 0
bk = 0
i = 0
while i<n and (ak<k or bk<k):
    ans+=l[i][0]
    if l[i][1] == l[i][2] == 1:
       ak+=1
       bk+=1
    
    elif l[i][1] == 1:
        ak+=1
        heappush(a,(-1*l[i][0]))
    
    elif l[i][2] == 1:
        bk+=1
        heappush(b,(-1*l[i][0]))
    else:
        ans-=l[i][0]
    i+=1
#print(ak,bk)
if ak>k :
    while ak>k and a:
        ans+=heappop(a)
        ak-=1
if bk>k :
    while bk> k and b:
        ans+=heappop(b)
        bk-=1
if i == n and (ak<k or bk<k):
    print(-1)
elif i == n or not(a or b):
    print(ans)
    
else:
    while i<n and (a and b):
        if l[i][1] == l[i][2] == 1:
            x =-1*heappop(a)
            y = -1*heappop(b)
            if x+y>=l[i][0]:
                ans-=(x+y-l[i][0])
            else:
                break
        i+=1
    print(ans)
            
    i+=1