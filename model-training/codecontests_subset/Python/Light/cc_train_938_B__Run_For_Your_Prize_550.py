n = int(input())

ai = list(map(int, input().split()))

a = []
for i in ai:
  if i > 10**6/2:
    a.append(abs(10**6/2 - i))
  else:
    a.append(abs(10**6/2 - i) + 1)
print(int(10**6/2 - min(a)))
