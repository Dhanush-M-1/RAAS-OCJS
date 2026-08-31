for _ in range(int(input())):
    n=int(input())
    arr=[]
    for i in range(n):
        arr.append(input())
    a=int(arr[0][1])
    b=int(arr[1][0])
    c=int(arr[n-1][n-2])
    d=int(arr[n-2][n-1])
    if a==b and c==d and c!=a:
        print(0)
    elif a==b and c!=d:
        if c==a:
            print(1)
            print(n,n-1)
        else:
            print(1)
            print(n-1,n)
    elif a!=b and c==d:
        print(1)
        if c==a:
            print(1,2)
        else:
            print(2,1)
    elif a==b and c==d:
        print(2)
        print(1,2)
        print(2,1)
    elif a!=b and c!=d:
        print(2)
        if a!=c:
            print(1,2)
            print(n,n-1)
        elif a!=d:
            print(1,2)
            print(n-1,n)