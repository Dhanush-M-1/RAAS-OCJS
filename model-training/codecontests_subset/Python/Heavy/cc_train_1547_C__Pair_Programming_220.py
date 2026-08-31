t = int(input())
for _ in range(t):
    input()
    k, n, m = [int(i) for i in input().split()]
    a = [int(i) for i in input().split()]
    b = [int(i) for i in input().split()]
    res = []
    i = 0
    j = 0

    ans = 1

    
    for _ in range(n + m):
        if i != n and a[i] <= k and ((j == m) or (a[i] <= b[j])):
            res.append(a[i])
            if a[i] == 0:
                k += 1
            i += 1
        elif j != m and b[j] <= k and ((i == n) or (b[j] < a[i])):
            res.append(b[j])
            if b[j] == 0:
                k += 1
            j += 1
        else:
            ans = 0
            break
            
    if ans:
        print(*res)
    else:
        print(-1)
