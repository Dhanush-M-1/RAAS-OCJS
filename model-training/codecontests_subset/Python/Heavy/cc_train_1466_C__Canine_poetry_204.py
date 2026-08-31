import sys
import io, os
input = sys.stdin.readline
#input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

T = int(input())
for _ in range(T):
    s = str(input().rstrip())
    s = list(s)
    s = [ord(c)-ord('a') for c in s]
    n = len(s)
    cur = 25
    ans = 0
    for i in range(1, n):
        if i != n-1:
            if s[i-1] == s[i] and s[i] == s[i+1]:
                ans += 2
                cur += 1
                s[i] = cur
                cur += 1
                s[i+1] = cur
            elif s[i-1] == s[i+1]:
                ans += 1
                cur += 1
                s[i+1] = cur
            elif s[i-1] == s[i]:
                ans += 1
                cur += 1
                s[i] = cur
        else:
            if s[i-1] == s[i]:
                ans += 1
                cur += 1
                s[i] = cur

    print(ans)
