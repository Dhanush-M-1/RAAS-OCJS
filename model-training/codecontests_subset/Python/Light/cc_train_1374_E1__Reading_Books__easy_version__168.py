n,k=map(int,input().split());alice=[];bob=[];both=[]
for i in range(n):
    t,a,b=map(int,input().split())
    if a&b: both.append(t)
    elif a: alice.append(t)
    elif b: bob.append(t)
alice.sort(); bob.sort();
for i in range(min(len(alice),len(bob))): both.append(alice[i]+bob[i])
print(-1 if(len(both)<k) else sum(sorted(both)[:k]))
exit()
