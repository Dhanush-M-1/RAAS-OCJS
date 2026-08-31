X=[]
H=[]
n=int(input())
for i in range(n):
    x,h=map(int,input().strip().split())
    X.append(x)
    H.append(h)
if n<=2:
    print(n)
else:
    c=2
    k=1
    while k<n-1:
        x=X[k]
        h=H[k]
        if x-h>X[k-1]:
            c+=1
        elif x+h<X[k+1]:
            c+=1
            X[k]+=h
        k+=1
    print(c)
    