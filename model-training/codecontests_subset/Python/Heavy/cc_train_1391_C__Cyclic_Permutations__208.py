import sys
input = sys.stdin.readline
N = int(input())
mod = 10 ** 9 + 7
class Factorial:
  def __init__(self, n, mod):
    self.mod = mod
    self.f = [1]
    for i in range(1, n + 1):
      self.f.append(self.f[-1] * i % mod)
    self.i = [pow(self.f[-1], mod - 2, mod)]
    for i in range(1, n + 1)[: : -1]:
      self.i.append(self.i[-1] * i % mod)
    self.i.reverse()
  def factorial(self, i):
    return self.f[i]
  def ifactorial(self, i):
    return self.i[i]
  def combi(self, n, k):
    return self.f[n] * self.i[n - k] % self.mod * self.i[k] % self.mod
  def permi(self, n, k):
    return self.f[n] * self.i[n - k] % self.mod
f = Factorial(N, mod)
print((f.factorial(N) - pow(2, N - 1, mod)) % mod)