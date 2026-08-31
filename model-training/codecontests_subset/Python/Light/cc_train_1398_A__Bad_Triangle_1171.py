for _ in range(int(input())):
    n=int(input())
    A=[int(_) for _ in input().split()]
    a,b=A[0],A[1]
    for _ in range(2,n):
        c=A[_]
        if (a+b)>c and (b+c)>a and (a+c)>b:
            continue
        else:
            print(1,2,_+1)
            break
    else:
        print(-1)