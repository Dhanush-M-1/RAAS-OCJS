t=int(input())
for i in range(t):
    a,b,c=map(int,input().split())
    if c<a or c>b:
        print(c)
    else:
        d=b//c
        print(c*(d+1))