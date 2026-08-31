from sys import stdin, stdout
input = stdin.readline
print = lambda x:stdout.write(str(x)+'\n')

M = 998244353
def nCr(n, r, M):
    return fact[n] * inv[n-r] % M * inv[r] % M


n, k = map(int, input().split())


fact = [1] * (n + 1)
inv = [1] * (n + 1)

for i in range(1, n + 1):
    fact[i] = fact[i-1] * i % M

inv[n] = pow(fact[n], M - 2, M)
for i in range(n-1, -1, -1):
    inv[i] = inv[i + 1] * (i + 1) % M

a = []
for _ in range(n):
    l, r = map(int, input().split())
    a.append(l+l)
    a.append(r+r+1)
a.sort()

cnts = 0
c = 0
for i in a:
    if i%2:
        c -= 1
    else:
        if c>=k-1:
            cnts += nCr(c, k-1, M)
        c += 1
print(cnts%M)