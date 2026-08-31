for _ in range(int(input())):
    n, m = map(int, input().split())
    s = input()
    l = list(map(int, input().split()))
    c = {}
    d = [0 for _ in range(26)]
    for i in l:
        if i in c:
            c[i] += 1
        else:
            c[i] = 1
    su = [0 for _ in s]
    su[-1] = 1
    for i in range(1, len(s)):
        if len(s) - i in c:
            su[len(s) - i - 1] += su[len(s) - i] + c[len(s) - i]
        else:
            su[len(s) - i - 1] += su[len(s) - i]
    for i in range(len(su)):
        d[ord(s[i]) - ord('a')] += su[i]
    print(*d)
