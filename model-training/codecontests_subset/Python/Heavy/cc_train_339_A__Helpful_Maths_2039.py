val = input()
oneCounter = 0
twoCounter = 0
threeCounter = 0
for c in val:
  if c == "1": oneCounter += 1
  elif c == "2": twoCounter += 1
  elif c == "3": threeCounter += 1
totalNumbers = oneCounter + twoCounter + threeCounter
result = ""

while totalNumbers > 0: 
  if oneCounter > 0: 
    result += "1"
    oneCounter -= 1
  elif twoCounter > 0: 
    result += "2"
    twoCounter -= 1
  elif threeCounter > 0: 
    result += "3"
    threeCounter -= 1
  if totalNumbers > 1:
    result += "+"
  totalNumbers -= 1

print(result)