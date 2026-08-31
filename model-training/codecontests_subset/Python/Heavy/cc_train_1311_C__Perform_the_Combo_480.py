for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    alpha = list('abcdefghijklmnopqrstuvwxyz')
    count = dict(zip(alpha, [0 for _ in range(26)]))
    sum = [0 for _ in range(n)]
    for i in range(m):
        if p[i] >= n:
            break
        sum[0] += 1
        sum[p[i]] -= 1
    else:
        sum[0] += 1
    # print(sum)
    su = 0
    for i in range(n):
        su += sum[i]
        count[s[i]] += su
    ans = []
    for key in alpha:
        ans.append(count[key])
    print(*ans)
