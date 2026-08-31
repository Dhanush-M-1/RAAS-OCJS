def getLines(num):
  inputLines = []
  for i in range(0,num):
    line = input()
    if line:
      inputLines.append(line)
    else:
        break
  return inputLines

def notZeroPow(num,p):
  return True if num >= 1 and num <= pow(10,p)  else False


lines = getLines(1)


result = 0

arr = [ int(e) for e in lines[0].split("+")]
arr.sort()

result = ""

for i , e in enumerate(arr):
    if i >= len(arr) - 1:
        result += str(e)
    else:
        result += str(e)+"+"

if len(arr) == 1:
    result = str(arr[0])


print(result)