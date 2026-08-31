n,m=(int(i) for i in input().split())
d=0
while d!=n:
    d+=1
    if d%m==0:
        n+=1
print(d)