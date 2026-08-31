"""
NTC here
"""
from sys import setcheckinterval,stdin
setcheckinterval(1000)

#print("Case #{}: {} {}".format(i, n + m, n * m))

iin=lambda :int(stdin.readline())
lin=lambda :list(map(int,stdin.readline().split()))
from collections import defaultdict
n,k=lin()
a=lin()
a.sort()
sol=[[0,0] for i in range(2*10**5+1)]
for i in a:
    ch=0
    x=i
    if sol[i][0]<k:
        sol[i][0]+=1
    while x>0:
        x//=2
        ch+=1
        if sol[x][0]<k:
            sol[x][0]+=1
            sol[x][1]+=ch 
ans=99999999999
#print(sol[:10])
for i,j in sol:
    if i>=k:
        ans=min(ans,j)
print(ans)
    