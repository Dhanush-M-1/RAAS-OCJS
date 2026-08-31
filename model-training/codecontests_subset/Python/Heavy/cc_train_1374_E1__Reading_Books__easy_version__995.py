import heapq
n, k = map(int, input().rstrip().split())
inn = []
inb = []
inc = []
for i in range(n):
    a,b,c = map(int, input().rstrip().split())
    if(b==0 and c==0):
        continue
    elif(b==1 and c==0):
        inb.append(a)
    elif(b==0 and c==1):
        inc.append(a)
    else:
        inn.append(a)


heapq.heapify(inb)
heapq.heapify(inc)
heapq.heapify(inn)
ans = 0
while(k>0):
    if(len(inb) and len(inc) and len(inn)):
        if(inb[0]+inc[0]<inn[0]):
            k1 = heapq.heappop(inb)
            k2 = heapq.heappop(inc)
            k-=1
            ans += (k1+k2)
        else:
            k1 = heapq.heappop(inn)
            ans += k1
            k-=1
    elif(len(inb) and len(inc)):
        k1 = heapq.heappop(inb)
        k2 = heapq.heappop(inc)
        k-=1
        ans += (k1+k2)
    elif(len(inn)):
        k1 = heapq.heappop(inn)
        ans += k1
        k-=1
    else:
        bool=False
        break

if(bool==True or k==0):
    print(ans)
else:
    print(-1)