t = int(input())
for i in range(t):
  n = int(input())
  seq = []
  for j in range(n):
    p, c = list(map(int, input().strip().split(' ')))
    seq.append([p, c])
  im = True
  if (n == 1 and seq[0][1] > seq[0][0]):
    print("NO")
    continue
  for j in range(1,n):
    prev = seq[j - 1]
    cur = seq[j]
    if (prev[1] > cur[1] or prev[0] > cur[0]):
      im = False
      break
    elif (prev[1] > prev[0] or cur[1] > cur[0]):
      im = False
      break
    elif ((cur[1] - cur[0]) > (prev[1] - prev[0])):
      im = False
      break
  print("YES" if im else "NO")