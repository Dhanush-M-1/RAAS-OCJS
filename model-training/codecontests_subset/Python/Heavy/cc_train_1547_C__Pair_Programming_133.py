for _ in range(int(input())):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    a.reverse()
    b.reverse()
    ans = []
    while a and b:
        if a[-1] == 0:
            ans.append(a.pop())
        elif b[-1] == 0:
            ans.append(b.pop())
        elif a[-1] <= b[-1]:
            ans.append(a.pop())
        else:
            ans.append(b.pop())
    ans += a[::-1] + b[::-1]
    for i in ans:
        if i == 0:
            k += 1
        elif i > k:
            print(-1)
            break
    else:
        print(*ans)
