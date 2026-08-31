a,b=map(int,input().split())
c=0
k=0
while a>0:
    a=a-1
    c=c+1
    k=k+1
    if c==b:
        a=a+1
        c=0
print(k)
    