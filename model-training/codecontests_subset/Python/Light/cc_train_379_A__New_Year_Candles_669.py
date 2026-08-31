a,b=map(int,input().split())
t=a
out=a
while out//b!=0:
    t+=out//b
    out=out-(out//b)*b+out//b
print(t)
