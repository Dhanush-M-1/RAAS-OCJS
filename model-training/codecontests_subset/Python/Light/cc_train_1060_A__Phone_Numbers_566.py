a=int(input())
b=input()
cnt=0
for i in b:
  if i=='8':
    cnt+=1

if a>=11:
  if b.find('8')>=0:
    x=a//11
    print(min(cnt, x))
  else:
    print("0")
else:
  print("0")