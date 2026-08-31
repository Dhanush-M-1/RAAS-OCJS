for _ in range(int(input())):
    n, m = map(int, input().split())
    s = list(input())
    nums = list(map(int, input().split()))
    prefix = [[0 for i in range(26)] for j in range(n)]
    prefix[0][ord(s[0]) - 97] = 1
    for i in range(1, n):
        prefix[i] = list(prefix[i-1])
        prefix[i][ord(s[i]) - 97] += 1

    ans = [0 for i in range(26)]
    nums.append(n)
    for e in nums:
        for x in range(26):
            ans[x] += prefix[e-1][x]

    print(' '.join(list(map(str, ans))))
"""
1
4 2
abca
1 3
"""