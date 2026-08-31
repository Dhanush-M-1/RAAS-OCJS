def countString(string, subString):
  length = len(subString)
  count = 0
  for i in range(len(string)-length+1):
    check = string[i:i+length]
    if check == subString:
      count += 1
  return count

n = int(input())

string = input()

grams = []
highestValue = 0
highestGram = ''

for i in range(n-1):
  grams.append(string[i:i+2])

grams = set(grams)

for gram in grams:
  count = countString(string,gram)
  if count > highestValue:
    highestValue = count
    highestGram = gram

print(highestGram)
