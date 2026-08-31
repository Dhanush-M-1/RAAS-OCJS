n=int(input())
L=["a"]
for i in range(n-1):
    tmp=[]
    for j in range(len(L)):
        for k in range(len(set(L[j]))+1):
            tmp.append(L[j]+chr(ord("a")+k))
    L=tmp
for j in range(len(L)):
    print(L[j])