t = int(input())

for _ in range(t):
    n = int(input())
    lst = [list(input()) for _ in range(n)]
    ans = []
    b1 = int(lst[0][1])
    b2 = int(lst[1][0])
    b3 = int(lst[n-1][n-2])
    b4 = int(lst[n-2][n-1])

    if b1==b2==b3==b4:
        ans.append((1,2))
        ans.append((2,1))

    elif b1==b2 and b3 != b4:
        if b1 == b3:
            ans.append((n,n-1))
        else:
            ans.append((n-1,n))

    elif b3==b4 and b1 != b2:
        if b3 == b1:
            ans.append((1,2))
        else:
            ans.append((2,1))

    elif b1 == b3 and b2 == b4:
        ans.append((1,2))
        ans.append((n-1,n))
    
    elif b1 == b4 and b2 == b3:
        ans.append((1,2))
        ans.append((n,n-1))

    if ans:
        print(len(ans))
        for i in ans:
            print(*i)
    else:
        print(0)