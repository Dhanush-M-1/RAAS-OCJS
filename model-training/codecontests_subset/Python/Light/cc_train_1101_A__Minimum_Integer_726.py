for _ in range(int(input())):
    n,m,d=map(int,input().split())
    if n/d>1:
        print(d)
    else:
        print(d*((m//d)+1))