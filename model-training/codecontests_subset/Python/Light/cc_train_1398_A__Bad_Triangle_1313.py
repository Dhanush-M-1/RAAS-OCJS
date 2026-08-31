a=int(input())
for i in range(a):
    b=int(input())
    l=list(map(int,input().split()))
    if l[0]+l[1]<=l[-1]:
        print(1,2,b)
    else:
        print(-1)
    