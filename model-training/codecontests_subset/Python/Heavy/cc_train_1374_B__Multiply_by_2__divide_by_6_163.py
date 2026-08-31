try:
  def checktwothree(x):
    cor = 1
    twoc = 0
    threec = 0
    if(x==1):
      return [True,0]
    while(x>1):
      if(x%2==0):
        twoc+=1
        x=int(x/2)
      elif(x%3==0):
        threec+=1
        x=int(x/3)
      else:
        cor=0
        break
    if(cor==1 and twoc<=threec):
      return [True,threec-twoc+threec]
    else:
      return [False,0,0]
  k = int(input())
  for i in range(k):
    t = int(input())
    verd = checktwothree(t)
    if(verd[0]):
      print(verd[1])
    else:
      print(-1)
except Exception:
  pass