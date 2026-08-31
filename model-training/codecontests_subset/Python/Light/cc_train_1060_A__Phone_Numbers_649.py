input()
b=input()
c=b.count('8')
result=len(b)//11
if c < result:
  print(c)
else:
  print(result)