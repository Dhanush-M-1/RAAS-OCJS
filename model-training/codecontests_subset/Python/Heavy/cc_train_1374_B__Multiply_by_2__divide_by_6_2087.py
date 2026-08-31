counts = []
n = int(input())

for i in range(n):
  counts.append(int(input()))

def norm_num(num):
  num2=0
  num3=0
  while num!=1:
    if(num%2==0):
      num/=2
      num2+=1
    elif(num%3==0):
      num/=3
      num3+=1
    else:
      return False
  if(num2<=num3):
    return True
  else:
    return False

for num in counts:
  res=num
  all=0
  ok=norm_num(num)
  while res!=1:
    if(res%6==0):
      res/=6
    else:
      res*=2
    all+=1
    if(not ok):
      all=-1
      break
  print(all)
  
