def solve(a,b,c):
  cnt = 0
  #while b!= 0:
  if b >= 1 and c >= 2:
    x = c//2
    rem = c%2
          
    if x <= b:
      cnt += x
      b = b-x
      c = rem

    else:  
      cnt += b
      b = 0
      c = c - (2*b)
      
  if b>1 and a > 0:
    x = b//2
    rem = b%2

    if x <= a:
      cnt += x
      a = a-x
      b = rem
    else:
      cnt += a
      a = 0
      b = b-(2*a) 

  return cnt*3


for i in range(int(input())):
  a,b,c = list(int(x) for x in input().split()) 
  print(solve(a,b,c))



