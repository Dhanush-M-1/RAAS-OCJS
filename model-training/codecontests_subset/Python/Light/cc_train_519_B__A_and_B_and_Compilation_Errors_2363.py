def list_xor(a, b):
  res = a[-1]
  for i in range(len(b)):
    res ^= a[i] ^ b[i]
  return res

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
print(list_xor(a, b))
print(list_xor(b, c))