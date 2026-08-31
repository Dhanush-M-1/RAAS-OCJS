d,x=[int(i) for i in input().split()]
f=0
k=0
while d>0:
    d=d-1
    f+=1
    k+=1
    if k==x:
        d+=1
        k=0
print(f)
