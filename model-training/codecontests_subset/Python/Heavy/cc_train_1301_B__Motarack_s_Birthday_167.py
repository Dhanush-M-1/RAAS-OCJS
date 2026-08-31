numTestcases = int(input())
for i in range (numTestcases):
  n = int(input())
  array = list(map(int, input().split(" ")))
  cMin = 9999999999
  cMax = 0
  for c in range (n):
    if array[c] == -1:
      if c != 0 and array[c - 1] != -1:
        cMin = min(cMin, array[c - 1])
        cMax = max(cMax, array[c - 1])
      if c != n - 1 and array[c + 1] != -1:
        cMax = max(cMax, array[c + 1])
        cMin = min(cMin, array[c + 1])
  if cMin == 9999999999:
    print("0 0")
  else:
    k = (cMax - cMin) // 2 + cMin
    m = 0
    for i in range (1, n):
      firstNum = array[i - 1]
      if firstNum == -1:
        firstNum = k
      secondNum = array[i]
      if secondNum == -1:
        secondNum = k
      m = max(abs(secondNum - firstNum), m)
    print(str(m) + " " + str(k))