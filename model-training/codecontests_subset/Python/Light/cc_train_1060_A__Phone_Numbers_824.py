N = int(input())
car = [int (i) for i in input()]
eight = 0
for i in car:
 if i == 8:
  eight += 1
nomera = N//11
if nomera < eight:
 print(nomera)
else:
 print(eight)