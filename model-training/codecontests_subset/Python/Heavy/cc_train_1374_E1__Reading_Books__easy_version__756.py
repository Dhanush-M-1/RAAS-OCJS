n,k = [int(i) for i in input().split()]
a=[]
b=[]
t=[]
for i in range (n):
    ti,ai,bi=[int(i) for i in input().split()]
    t.append([ti,i])
    a.append(ai)
    b.append(bi)
temp = 0
if a.count(1)<k or b.count(1)<k:
    temp = 1
    print(-1)
if temp == 0:
    alice=[]
    bob=[]
    both = []
    for i in range (n):
        if a[i]==1 and b[i]==0:
            alice.append(t[i][0])
        if b[i]==1 and a[i]==0:
            bob.append(t[i][0])
        if a[i]==1 and b[i]==1:
            both.append(t[i][0])
    alice.sort()
    bob.sort()
    both.sort()
    alice.reverse()
    bob.reverse()
    both.reverse()
    aa,bb=k,k
    ans = 0
    while(aa and bb):
        if len(both)>0 :
            if len(alice)>0 and len(bob)>0:
                if both[-1]<=alice[-1]+bob[-1]:
                    aa-=1
                    bb-=1
                    ans+=both[-1]
                    both.pop()
                else:
                    aa-=1
                    bb-=1
                    ans+=alice[-1]+bob[-1]
                    alice.pop()
                    bob.pop()
            else:
                aa-=1
                bb-=1
                ans+=both[-1]
                both.pop()
        else:
            aa-=1
            bb-=1
            ans+=alice[-1]+bob[-1]
            alice.pop()
            bob.pop()
        
    if aa>0:
        for i in  range (aa):
            ans+=alice[len(alice)-1-i]
    if bb>0:
        for i in range (bb):
            ans+=bob[len(bob)-1-i]
    print(ans)