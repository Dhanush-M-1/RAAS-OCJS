n = int(input())
while(n):
  n = n - 1
  s = input()
  s = s.split()
  a = s[0]
  b = s[1]
  flag = 0
  if(a < b):
    print(a)
  else:
    a = list(a)
    for i in range(0,len(a) - 1):
      j = min((r for r in range(i + 1,len(a))), key=lambda x: (a[x], -x))
      if(a[i] > a[j]):
        a[i],a[j] = a[j],a[i]
        break
    a = ''.join(a)
    if(a < b):
      print(a)
    else:
      print('---')

# #-*- encoding:utf-8 -*-
 
# string = 'abc123456'
# i=3
# j=5
# print string
# temp = string[j]
# trailer = string[j+1:] if j + 1 < len(string) else ''
# string = string[0:j] + string[i] + trailer
# string = string[0:i] + temp + string[i+1:]
# print string
