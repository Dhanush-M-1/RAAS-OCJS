x=int(input())
for i in range(x):
    a,b,c=map(int,input().split())
    if a>c:
        print(c*1)
    else:
        print((b//c+1)*c)