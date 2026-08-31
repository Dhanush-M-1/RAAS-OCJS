ans = 0
leftover = 0
[a, b] = list(map(int, input().split()))
while(a):
    ans += a
    leftover += a
    a = int(leftover / b)
    leftover %= b
print(ans, end = '')