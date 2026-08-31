for i in range(int(input())):
    a=int(input())
    b=list(map(int,input().split()))
    c=b[0]+b[1]
    d=True
    for j in range(2,a):
        if b[j]>=c:
            d=False
            break
    if d==False:
        print(1,2,j+1)
    else:
        print(-1)