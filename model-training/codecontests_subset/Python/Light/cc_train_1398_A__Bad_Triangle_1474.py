import copy
for ii in range(int(input())):
    n=int(input())
    a=list(map(int , input().split()))
    b=copy.deepcopy(a)
    b.sort()
    x=b[0]
    y=b[1]
    z=b[n-1]
    if x+y<=z:
        print(1,2,n)

    else:
        print(-1)














