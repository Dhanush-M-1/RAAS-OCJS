def comb(n, k):
  c = 1
  for i in range(k):
    c *= n-i
    c //= i+1
  return c

n = [int(i) for i in input()]
l = len(n)
k = int(input())
count = 0
for i in range(l):
  if n[i] > 0:
    # n[:i] 0 {1..9}*k 0*(l-i-1-k)
    count += 9 ** k * comb(l-i-1, k)
    # n[:i] {1..(n[i]-1)} {1..9}*(k-1) 0*(l-i-1-k)
    if k >= 1:
      count += 9 ** (k-1) * comb(l-i-1, k-1) * (n[i]-1)
    else:
      break
    # Next is n[:i+1] {1..9}*(k-1) 0*(l-i-k)
    k -= 1
  if i == l-1 and k == 0:
    count += 1
print(count)