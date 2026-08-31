n=int(input())
l,r=1,int(1e6)
a=map(int,input().split())
for i in a:
    if i<=int(5e5) and i>l:
        l=i
    if i>int(5e5) and i<r:
        r=i
print(max(l-1,int(1e6)-r))