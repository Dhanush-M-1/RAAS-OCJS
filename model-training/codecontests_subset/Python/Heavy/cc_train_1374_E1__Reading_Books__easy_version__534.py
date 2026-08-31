import heapq
n,k=map(int,input().split())
both=[]
alice=[]
bob=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a==1 and b==1:
        both.append(t)
    elif a==1 and b==0:
        alice.append(t)
    elif a==0 and b==1:
        bob.append(t)
heapq.heapify(both)
heapq.heapify(alice)
heapq.heapify(bob)
at,bt,count=0,0,0
while len(both)>0 and len(alice)>0 and len(bob)>0 and at<k and bt<k:
    x=heapq.heappop(both)
    y=heapq.heappop(alice)
    z=heapq.heappop(bob)
    if x<(y+z):
        at+=1
        bt+=1
        count+=x
        heapq.heappush(alice,y)
        heapq.heappush(bob,z)
    else:
        at+=1
        bt+=1
        count+=(y+z)
        heapq.heappush(both,x)
if len(both)>0 and (len(alice)==0 or len(bob)==0) and at<k and bt<k:
    while len(both)>0 and at<k and bt<k:
        x=heapq.heappop(both)
        at+=1
        bt+=1
        count+=x        
elif len(both)==0 and len(alice)>0 and len(bob)>0 and at<k and bt<k:
    while len(alice)>0 and len(bob)>0 and at<k and bt<k:
        x=heapq.heappop(alice)
        y=heapq.heappop(bob)
        at+=1
        bt+=1
        count+=(x+y)
if at!=k or bt!=k:
    print(-1)
else:
    print(count)                            