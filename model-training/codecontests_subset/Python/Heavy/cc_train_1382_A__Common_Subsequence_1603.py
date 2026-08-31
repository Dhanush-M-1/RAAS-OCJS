t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    flag = 0
    if m>n:
        for i in range(n):
            if a[i] in b:
                print("YES")
                print(1,a[i])
                flag = 1
                break
    else:
        for i in range(m):
            if b[i] in a:
                print("YES")
                print(1,b[i])
                flag = 1
                break
    if flag == 0:
        print("NO")
        