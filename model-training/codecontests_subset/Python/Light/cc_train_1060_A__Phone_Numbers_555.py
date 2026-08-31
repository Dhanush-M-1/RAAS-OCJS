n = int(input())

array = list(input())

eight = 0
notEight = 0

for x in array:
  if x == '8':
    eight += 1
  else:
    notEight+= 1

solution = 0

while(eight > 0 and eight + notEight > 10):
  solution += 1
  eight -= 1
  if notEight < 10:
    eight -= (10 - notEight)
    notEight = 0
  else:
    notEight -= 10

print(solution)