n, m = map(int, input().split())
A = set([int(input()) for _ in range(m)])
p, q = 0, 1
mod = 10 **9 + 7
for i in range(1, n+1):
    p, q = q, ((p+q)%mod)*(i not in A)
print(q)