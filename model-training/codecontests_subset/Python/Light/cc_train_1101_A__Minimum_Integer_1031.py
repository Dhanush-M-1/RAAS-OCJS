for i in range(int(input())):
    a,b,c=map(int,input().split())
    r= b - b%c + c
    if a<=c:
        print(r)
    else:
        print(c)