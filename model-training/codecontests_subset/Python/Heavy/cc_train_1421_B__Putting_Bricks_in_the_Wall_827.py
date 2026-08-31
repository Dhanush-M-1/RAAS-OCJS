t=int(input())
for i in range(t):
   size = int(input())
   lines = []
   for j in range(size):
      lines.append(input())
   d0,d1,f0,f1=0,0,0,0
   if lines[0][1] == '1':
      d1 += 1
   if lines[1][0] == '1':
      d1 += 1
      
   if lines[-1][-2] == '1':
      f1 += 1
   if lines[-2][-1] == '1':
      f1 += 1
   rep = []
   if d1 in [0,2] and f1 in [0,2]:
      if d1 != f1:
         print(0)
      else:
         print(2)
   elif d1==1 and f1 == 1:
      print(2)
   else:
      print(1)
   if d1 == 0:
      if lines[-1][-2] == '0':
         print(size,size-1)
      if lines[-2][-1] == '0':
         print(size-1,size)
   elif d1 == 1:
      if f1 == 0:
         if lines[0][1] == '0':
            print(1, 2)
         if lines[1][0] == '0':
            print(2, 1)
      if f1 == 1:
         if lines[0][1] == '0':
            print(1, 2)
         if lines[1][0] == '0':
            print(2, 1)
         if lines[-1][-2] == '1':
            print(size, size-1)
         if lines[-2][-1] == '1':
            print(size-1, size)
      if f1 == 2:
         if lines[0][1] == '1':
            print(1, 2)
         if lines[1][0] == '1':
            print(2, 1)
   else:
      if lines[-1][-2] == '1':
         print(size,size-1)
      if lines[-2][-1] == '1':
         print(size-1,size)
   
