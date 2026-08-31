n = int(input())


emne1 = input()
temparray = (emne1.split())
array = []
for s in temparray:
  array.append(int(s))
array.sort()


emne2 = input()
temparray = (emne2.split())
array2 = []

for s in temparray:
  array2.append(int(s))
array2.sort()

emne3 = input()
temparray = (emne3.split())
array3 = []
for s in temparray:
  array3.append(int(s))
array3.sort()

bl1 = True
for s in range(0,n-1):
  if array[s] != array2[s]:
    bl1 = False
    print(array[s])
    break

if bl1 == True:
  print(array[-1])


bl1 = True
for s in range(0,n-2):
  if array3[s] != array2[s]:
    bl1 = False
    print(array2[s])
    break

if bl1 == True:
  print(array2[-1])