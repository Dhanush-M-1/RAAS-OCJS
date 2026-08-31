S = list(input())
N = len(S)


Z = 0
SUM = 0
for s in S:
  if s == "1":
    SUM += 1
    Z = max(Z,SUM)
  else:
    SUM -= 1

ruiseki_max = [0]
MAX = SUM
for s in S[1:][::-1]:
  if s == "1":
    SUM -= 1
  else:
    SUM += 1
    MAX = max(MAX,SUM)
  ruiseki_max.append(MAX-SUM)

def f(Z):
  SUM = 0
  MIN = 0
  for i in range(N):
    s = S[i]
    if s == "1":
      SUM += 1
    elif s == "0":
      SUM -= 1
      MIN = min(MIN,SUM)
    else:
      if SUM + 1 + ruiseki_max[N-1-i] <= Z:
        SUM += 1
      else:
        SUM -= 1
        MIN = min(MIN,SUM)
  return MIN

print(min(Z-f(Z),(Z+1-f(Z+1))))