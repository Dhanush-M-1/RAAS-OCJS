n=int(input())
for _ in range(n):
    l,r,d=map(int,input().split())
    if d<l:
        print(d)
    else:
        ans=r%d
        print(r+abs(d-ans))