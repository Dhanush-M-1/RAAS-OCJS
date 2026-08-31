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
sol=defaultdict(list)

for i in a:
    ch=0
    x=i
    sol[i].append([i,ch])
    while x>0:
        x//=2
        ch+=1
        sol[x].append([i,ch]) 
ans=999999
for i in sol:
    if len(sol[i])>=k:
        ch=0
        sol[i].sort()
        for j in range(k):
            ch+=sol[i][j][1]
        ans=min(ch,ans)
print(ans)
    