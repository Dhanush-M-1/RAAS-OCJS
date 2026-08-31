chr='abcdefghijklmnopqrstuvwxyz'
a=[0]*int(input())
while 1:
  print(''.join(chr[i]for i in a))
  if a==list(range(len(a))):break
  a[-1]+=1
  i=-1
  while a[i]-max(a[:i]+[0])>1:
    a[i]=0
    i-=1
    a[i]+=1