from sys import stdin
n = int(stdin.readline())
a = list(stdin.readline().split())
d = dict()
for x in range(13):
    d[x] = 0
for x in a:
    d[len(x)] += 1
ans = 0
MOD = 998244353
for x in a:
    for y in d:
        if d[y]:
            str1 = ''
            str2 = ''
            temp = x[::-1]
            z = 0
            while z < min(len(x), y):
                str1 += temp[z]
                str1 += '0'
                str2 += '0'
                str2 += temp[z]
                z += 1
            while z < len(x):
                str1 += temp[z]
                str2 += temp[z]
                z += 1
            ans += ((int(str1[::-1]) + int(str2[::-1])) * d[y]) % MOD

print(ans % MOD)
