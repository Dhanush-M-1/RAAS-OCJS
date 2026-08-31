n=int(input())
s=n
X=[]
H=[]
while s>0:
    x,h=map(int,input().split())
    X+=[x]
    H+=[h]
    s-=1

if n==0 or n==1:
    print(n)
else:
    Y=[0]
    for i in range(1,n-1):
        
        if X[i]-H[i]>X[i-1] and X[i]-H[i]> Y[-1]:
            Y+=[X[i]-H[i]]
            continue
        if X[i]+H[i]<X[i+1]:
            Y+=[X[i]+H[i]]
    print(len(Y)+1)