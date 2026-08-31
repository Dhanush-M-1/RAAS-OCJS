import operator as op
from functools import reduce
def ncr(n, r):
    r = min(r, n-r)
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return numer//denom

first_line = [int(i) for i in input().split()]
n, m = first_line[0], first_line[1]
books = [int(i) for i in input().split()]
cnt = [0] * m
fact = [0] * (n + 1)

fact[n] = ncr(n, 2)
total_options = fact[n]

for b in books:
    cnt[b - 1] += 1

for i in cnt:
    if i > 1:
        if fact[i] == 0:
            fact[i] = ncr(i, 2)
        total_options -= fact[i]

print(int(total_options))
