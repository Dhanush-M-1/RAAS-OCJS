n = int(input())
l = list(map(int, input().split()))
ans = -1
for i in l:
    a = i-1
    b = 10**6-i
    ans = max(ans, min(a, b))
print(ans)