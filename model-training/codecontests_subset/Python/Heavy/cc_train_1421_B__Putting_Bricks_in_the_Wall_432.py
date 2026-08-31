T, = map(int, input().split())
for _ in range(T):
    N, = map(int, input().split())
    X=[]
    for _ in range(N):
        X.append(input().strip())
    a,b=int(X[0][1]),int(X[1][0])
    c,d=int(X[-1][-2]),int(X[-2][-1])
    if (a,b,c,d)==(1,1,0,0):
        print(0)
    if (a,b,c,d)==(0,0,1,1):
        print(0)
    if (a,b,c,d)==(0,0,0,0):
        print(2)
        print(1, 2)
        print(2, 1)
    if (a,b,c,d)==(1,1,1,1):
        print(2)
        print(1, 2)
        print(2, 1)

    if (a,b,c,d)==(0,1,0,1):
        print(2)
        print(1, 2)
        print(N-1, N)
    if (a,b,c,d)==(1,0,1,0):
        print(2)
        print(1, 2)
        print(N-1, N)
    if (a,b,c,d)==(1,0,0,1):
        print(2)
        print(1, 2)
        print(N, N-1)
    if (a,b,c,d)==(0,1,1,0):
        print(2)
        print(1, 2)
        print(N, N-1)

    if (a,b,c,d)==(0,0,0,1):
        print(1)
        print(N, N-1)
    if (a,b,c,d)==(1,1,1,0):
        print(1)
        print(N, N-1)
    if (a,b,c,d)==(0,0,1,0):
        print(1)
        print(N-1, N)
    if (a,b,c,d)==(1,1,0,1):
        print(1)
        print(N-1, N)
    if (a,b,c,d)==(0,1,0,0):
        print(1)
        print(1, 2)
    if (a,b,c,d)==(1,0,1,1):
        print(1)
        print(1, 2)
    if (a,b,c,d)==(1,0,0,0):
        print(1)
        print(2, 1)
    if (a,b,c,d)==(0,1,1,1):
        print(1)
        print(2, 1)

    
