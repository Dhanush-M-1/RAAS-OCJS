mod = 998244353

def count_digits(x):
  return len(str(x))

n = int(input())
a = [int(x) for x in input().split(' ')]
digs = [0] * 11
ans = 0

for ai in a:
  digs[count_digits(ai)] += 1

for ai in a:
  x = ai
  g = 1

  for d in range(1, 11):
    x = (x % g) + (x // g) * 10 * g
    g *= 100
    ans = (ans + ( (digs[d] * x) % mod ) ) % mod
  

  x = ai
  g = 10

  for d in range(1, 11):
    x = (x % g) + (x // g) * 10 * g
    g *= 100

    ans = (ans + ( (digs[d] * x) % mod )) % mod
  


print(ans)
