n=int(input())
X=[]
H=[]
for i in range(n):
    x,h=map(int,input().split())
    X.append(x)
    H.append(h)
if n>1:
    r=2
else:
    r=1
for i in range(1,n-1):
    if X[i]-X[i-1]>H[i]:
        r+=1
    elif X[i+1]-X[i]>H[i]:
        r+=1
        X[i]=X[i]+H[i]
print(r)
