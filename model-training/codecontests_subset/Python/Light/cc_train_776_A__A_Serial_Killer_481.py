s = list(input().split())
print(*s)
n = int(input())
for i in range(n):
    x = list(input().split())
    s[s.index(x[0])] = x[1]
    print(*s)
