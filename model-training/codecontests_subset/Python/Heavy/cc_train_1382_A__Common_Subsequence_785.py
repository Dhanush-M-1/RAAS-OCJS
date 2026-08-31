for ii in range(int(input())):
    n , m = map(int , input().split())
    a = list(map(int , input().split()))
    b = list(map(int , input().split()))
    x= min(n,m)
    a.sort()
    b.sort()
    if x==m:
        c = 0
        for i in range(x):
            if b[i] in a:
                print("YES")
                print(1,b[i])
                c+=1
                break
        if c==0:
            print("NO")
    else:
        c = 0
        for i in range(x):
            if a[i] in b:
                print("YES")
                print(1,a[i])
                c+=1
                break
        if c==0:
            print("NO")

