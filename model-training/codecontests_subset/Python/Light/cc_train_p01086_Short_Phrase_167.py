
while True:
  n = int(input())
  if n == 0:
    break
  haiku=[5,7,5,7,7]
  mojicnt=0
  iti=0
  s=[]
  for i in range(n):
    s.append(input())
  for i in range(n):
    for j in range(i,n):
      mojicnt += len(s[j])
      if mojicnt > haiku[iti]:
        continue
      elif mojicnt == haiku[iti]:
        iti+=1
        mojicnt=0
        if iti == 5:
          print(i+1)
          break
    if iti == 5:
      break
    else:
      mojicnt=0
      iti=0

