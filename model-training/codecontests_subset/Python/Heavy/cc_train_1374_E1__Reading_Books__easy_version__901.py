n,k=map(int,input().split())
alice=[]
bob=[]
both=[]
for _ in range(n):
    t,a,b=map(int,input().split())
    if a and b:
        both.append(t)
    elif(a):
        alice.append(t)
    elif(b):
        bob.append(t)
if len(alice)+len(both)<k or len(bob)+len(both)<k:
    print(-1)
else:
    alice.sort()
    bob.sort()
    both.sort()
    i=j=0
    ans=0
    while i<len(alice) and i<len(bob) and j<len(both) and k>0:
        if(alice[i]+bob[i]<both[j]):
            ans+=alice[i]+bob[i]
            i+=1
        else:
            ans+=both[j]
            j+=1
        k-=1
    if(k):
        if(j>=len(both)):
            while k>0:
                ans+=alice[i]+bob[i]
                i+=1
                k-=1
        else:
            while k>0:
                ans+=both[j]
                j+=1
                k-=1
    print(ans)