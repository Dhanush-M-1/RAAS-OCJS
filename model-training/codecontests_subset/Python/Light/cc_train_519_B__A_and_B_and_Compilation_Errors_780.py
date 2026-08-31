n=int(input())
q=2
D={}
for i in list(input().split()):
    if i in D:
        D[i]+=1
    else:
        D[i]=1
while q!=0:
    D1=D.copy()
    q-=1
    lt=list(input().split())
    for i in lt:
        if D1[i]>1:
            D1[i]-=1
        else:
            del(D1[i])
    for i in D1.keys():
        k=i
        print(i)
    if D[k]>1:
        D[k]-=1
    else:
        del(D[k])
