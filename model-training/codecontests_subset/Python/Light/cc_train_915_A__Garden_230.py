n,m=list(map(int,input().strip().split()))
l=list(map(int,input().strip().split()))
t=[]
for i in l:
    if m%i==0:
        t +=[i]
ma=max(t)
print(m//ma)
