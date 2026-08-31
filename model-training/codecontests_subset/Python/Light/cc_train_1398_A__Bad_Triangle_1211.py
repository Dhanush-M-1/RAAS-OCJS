for i in range(int(input())):
    n = int(input())
    l = list(map(int,input().split()))
    a = 0
    b = 1
    c = 2
    knt = 0
    while c<n:
        if l[a] + l[b] <= l[c]:
            print(a+1,b+1,c+1)
            knt = 1
            break
        c+=1
    if knt == 0:
        print("-1")
