n=int(input())
for i in range(n):
    l,r,d=map(int,input().split())
    if d<l:
        print(d)
    else:
        op=r//d
        print((op+1)*d)
            