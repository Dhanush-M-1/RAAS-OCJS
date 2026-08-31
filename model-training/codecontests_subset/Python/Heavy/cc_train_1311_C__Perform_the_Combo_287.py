t = int(input())
for i in range(t):
    n, m = map(int, input().split())
    q = m
    s = input()
    a = list(map(int, input().split()))
    res = [0 for x in range(26)]
    a.sort()
    j = 0
    for i in range(n):
        res[ord(s[i]) - 97] += m + 1
        if j < q:
            while a[j] <= i + 1 and j < q - 1:
                j += 1
                m -= 1
            if j == q - 1:
                if a[j] <= i + 1:
                    m -= 1
                    j = q
    print(*res)
        
    