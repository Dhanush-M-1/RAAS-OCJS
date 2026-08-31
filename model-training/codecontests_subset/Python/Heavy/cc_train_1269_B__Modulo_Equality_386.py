def isvalid(x):
    hashic=hashi.copy()
    for i in ai:
        z=(i+x)%m
        if(z not in hashic or hashic[z]==0):
            return 0
        else:
            hashic[z]-=1
    return 1
l=input().split()
n=int(l[0])
m=int(l[1])
a=input().split()
ai=[int(i) for i in a]
b=input().split()
bi=[int(i) for i in b]
hashi=dict()
for i in bi:
    if i in hashi:
        hashi[i]+=1
    else:
        hashi[i]=1
mina=[]
for i in range(n):
    x=(bi[i]-ai[0])%m
    if(isvalid(x)):
        mina.append(x)
print(min(mina))