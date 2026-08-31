def candles(a,b): 
  a1=a//b
  if(a==b):
    return 1
  elif(a<b):
    return 0
  else :
    a=a-(a//b)*b+a//b
    return(a1+candles(a,b))
a1,b1=input().split()
a=int(a1)
b=int(b1)
print(a+candles(a,b))