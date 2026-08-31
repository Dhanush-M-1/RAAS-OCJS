for t in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    c=l[n-1]
    b=l[1]
    a=l[0]
    if a+b<=c or b+c<=a or c+a<=b:
        print(1,2,n)
    else:
        print(-1)
        