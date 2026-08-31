a,b=map(int,input().split())
s=0
r=a
i=0
while r>0:
    i=i+1
    r=r-1
    s=s+1
    if s==b:
        s=0
        r=r+1
print(i) 