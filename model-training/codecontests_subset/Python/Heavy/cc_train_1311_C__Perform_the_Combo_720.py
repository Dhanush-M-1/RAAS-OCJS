def read():
    n, m = map(int, input().split())
    s = input()
    p = list(map(int, input().split()))
    return n, m, s, p


def solve(n, m, s, p):
    a = [[0] * (n + 1) for i in range(26)]
    ord_a = ord('a')
    for i in range(n):
        for j in range(26):
            a[j][i + 1] = a[j][i]
        a[ord(s[i]) - ord_a][i + 1] += 1

    res = [0] * 26
    p.append(n)
    for pi in p:
        for i in range(26):
            res[i] += a[i][pi]
    return res


for t in range(int(input())):
    result = solve(*read())
    print(*result)