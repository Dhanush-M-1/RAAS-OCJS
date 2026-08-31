a, b = map(int, input().split())
ans = 0
s = 0
while(a > 0):
    a -= 1
    s += 1
    if(s == b):
        s = 0
        a += 1
    ans += 1

print(ans)