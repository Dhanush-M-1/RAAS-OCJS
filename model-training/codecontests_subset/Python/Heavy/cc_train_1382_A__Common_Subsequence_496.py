for _ in range(int(input())):
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    c = []
    flg = 0
    if n > m:
        for i in b:
            if i in a:
                print("YES")
                print(1,i)
                flg = 1
                break
    else:
        for i in a:
            if i in b:
                print("YES")
                print(1,i)
                flg = 1
                break
    if flg == 0:
        print("NO")
        