def func(a,b):
  s=''
  s1=''
  while a>0:
    s=str(a%2)+s
    a=a//2
  while b>0:
    s1=str(b%2)+s1
    b=b//2
  x=max(len(s),len(s1))
  if x==len(s):
    s1=(x-len(s1))*'0'+s1
  else:
    s=(x-len(s))*'0'+s
  
  xor=''
  for i in range(x):
    if s[i]==s1[i]:
      xor+='0'
    else:
      xor+='1'
  xor=xor[::-1]
  intXor=0
  for i in range (len(xor)):
    intXor=intXor+(int(xor[i])*(2**i))
  return intXor

list_of_solutions=[]
x=int(input())
for i in range(x):
  a,b,n=tuple(map(int,input().split()))
  x=(n-2)/3
  y=(n-3)/3
  x=str(x)
  y=str(y)
  x=x[x.index('.')+1:]
  y=y[y.index('.')+1:]
  if x=='0' and n>=2:
      list_of_solutions.append(func(a,b))
  elif n==1:
    list_of_solutions.append(b)
  elif n==0:
      list_of_solutions.append(a)
  else:
    if y=='0':
     list_of_solutions.append(a)
    else:
     list_of_solutions.append(b)

for i in list_of_solutions:
  print(i)