t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    s = [i for i in input()]
    p = list(map(int, input().split()))
    
    if n == 1:
        print(1)
    else:
        mp = [1]*n
        p = sorted(p)[::-1]
        mp[p[0]-1] = 2

        for i in range(1, m):
            mp[p[i]-1] = mp[p[i-1]-1] + 1

        ls = mp[-1]
        for i in range(n-1, -1, -1):
            if mp[i] != 1:
                ls = mp[i]
            else:
                mp[i] = ls

        d = {chr(97+i):0 for i in range(26)}

        for i in range(n):
            d[s[i]] += mp[i]

        print(*d.values())