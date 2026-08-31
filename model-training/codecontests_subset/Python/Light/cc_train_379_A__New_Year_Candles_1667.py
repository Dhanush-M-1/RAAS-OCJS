a, b = [int(x) for x in input().split()]
ans = 0
while (a >= b):
    ans += b*(a//b);
    a = a//b+a%b;
ans += a
print(ans)