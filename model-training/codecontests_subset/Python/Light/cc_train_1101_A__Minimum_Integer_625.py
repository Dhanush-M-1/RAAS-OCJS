a=int(input())
k=[]
for i in range(a):
    b,c,d=list(map(int,input().split()))
    if d<b:
        k.append(d)
    else:
        k.append((c//d+1)*d)
for i in range(a):
    print(k[i])