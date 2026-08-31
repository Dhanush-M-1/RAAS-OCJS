n=int(input())
for i in range(n):
    l,r,m=map(int,input().split())
    if l>m:
        print(m)
    else:print(((r//m)+1)*m)