n,k=map(int,input().split())
choose=list(map(int,input().split()))
for i in choose:
    if k%i!=0:choose[choose.index(i)]=0
while 0 in choose:choose.remove(0)
print(k//max(choose))