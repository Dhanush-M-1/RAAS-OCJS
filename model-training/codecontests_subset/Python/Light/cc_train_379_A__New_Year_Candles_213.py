s = input().split()
a, b = int(s[0]), int(s[1])
ans = 0
went = 0
while True:
    a -= 1
    ans += 1
    went += 1
    if went >= b:
        went -= b
        a += 1
    if a == 0:
        break
print(ans)
