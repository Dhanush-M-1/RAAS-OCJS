def gcd(a,b):
  if b==0:
    return a
  else:
    return gcd(b,a%b)

def solve(a,b,c,d):
  if a < b or d < b:
    return True

  cnt=gcd(b,d)
  mi=a-b
  ma=a-c
  if ma-mi > cnt :
    return True
  elif ma-mi <= 1:
    return False
  elif (mi+cnt)//cnt*cnt < ma:
    return True
  else:
    return False

T=int(input())
for i in range(T):
  A,B,C,D=map(int,input().split())
  if solve(A,B,C,D):
    print("No")
  else:
    print("Yes")