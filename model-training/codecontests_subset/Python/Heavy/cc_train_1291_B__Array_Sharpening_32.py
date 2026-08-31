t = int(input())
for t0 in range(t):
 n = int(input())
 list1 = input().split(' ')
 j1 = True
 j2 = True
 j3 = True
 if n == 1:
  print('Yes')
 
 elif n % 2 == 1:
  n1 = int((n+1)/2)

  n2 = int(-n1)
  for n0 in range (0,n1):
   if int(list1[n0]) < n0:
    j1 = False
   
  for n0 in range(n2,0):
   if int(list1[n0]) < -n0-1:
    j2 = False
   
  if j1 == True and j2 == True:
   print('Yes')
  else:
   print('No')
 else:
  n1 = int(n/2)
  n2 = int(-n/2)
  n3 = int(n/2 - 1)
  for n0 in range(0,n1):
   if int(list1[n0]) < n0:
    j1 = False
   
  for n0 in range(n2,0):
   if int(list1[n0]) < -n0-1:
    j2 = False
  if int(list1[n3]) == n3 and int(list1[n1]) == n3:
   j3 = False
  if j1 == True and j2 == True and j3 == True:
   print('Yes')
  else:
   print('No')