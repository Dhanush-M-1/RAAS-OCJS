for _ in range(int(input())):
    a,b,d=map(int,input().split())
    if a>d:
        print(d)
    elif b<d:
        print(d)
    else:
        x=b//d
        print(d*(x+1))