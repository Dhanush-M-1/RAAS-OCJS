# python template for atcoder1
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

N = int(input())
ans = []
for _ in range(N):
    n = int(input())
    s = input()[:-1]
    if all(c == "<" for c in s):
        ans.append(0)
    elif all(c == ">" for c in s):
        ans.append(0)
    else:
        first = -1
        last = -1
        for i in range(n):
            if s[i] == ">":
                first = i
                break
        for i in reversed(range(n)):
            if s[i] == "<":
                last = n - i-1
                break
        ans.append(min(first, last))
print("\n".join(map(str, ans)))
