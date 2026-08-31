def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

n = int(input())
s = list(map(int, input().split()))
s.sort()
dp = [0] * ((10 ** 6) + 100)

res = s[0]
for ss in s:
    dp[ss] += 1
    res = gcd(res, ss)

A = max(s)
pairwise = True
setwise = (res == 1)

for i in range(2, A + 1):
    cnt = 0
    for j in range(i, A + 1, i):
        cnt += dp[j]
    if cnt > 1:
        pairwise = False
        break

if pairwise:
    print("pairwise coprime")
elif setwise:
    print("setwise coprime")
else:
    print("not coprime")
