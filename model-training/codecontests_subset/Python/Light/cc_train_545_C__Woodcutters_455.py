m = int(input())
x = []
h = []
for k in range(m):
  q = [int(i) for i in input().split(' ')]
  x.append(q[0])
  h.append(q[1])

def main():
  if m <= 2:
    return m
  s=2
  for i in range(1, m-1):
    if x[i]-h[i] > x[i-1]:
      s+=1
      continue
    elif x[i]+h[i] < x[i+1]:
      s += 1
      x[i] += h[i]
  return s

print(main())
