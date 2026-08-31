a, b = map(int, input().split())
ans = a
new = 0
remain = a
while(remain >= b):
    new = remain // b
    remain %= b
    ans += new
    remain += new
    new = 0
print(ans)