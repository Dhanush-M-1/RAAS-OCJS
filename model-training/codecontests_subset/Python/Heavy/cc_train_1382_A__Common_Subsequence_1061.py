for t in range(int(input())):
    n,m=[int(i) for i in input().split()]
    a=[int(i) for i in input().split()]
    b=[int(i) for i in input().split()]
    if n>m:
        f=0
        for i in range(m):
            if b[i] in a:
                f=1
                print("YES")
                print(1,b[i])
                break
        if f==0:
            print("NO")
    else:
        f=0
        for i in range(n):
            if a[i] in b:
                f=1
                print("YES")
                print(1,a[i])
                break
        if f==0:
            print("NO")