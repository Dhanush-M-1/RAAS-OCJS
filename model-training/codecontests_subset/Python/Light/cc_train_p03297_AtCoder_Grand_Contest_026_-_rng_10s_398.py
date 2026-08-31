from fractions import gcd
T=int(input())
for i in range(T):
  A,B,C,D=map(int,input().split())
  if B<=A and B<=D:
    if B<=C:
      print("Yes")
    else:
      G=gcd(B,D)
      a=A%G
      t=(C-a)//G+1
      if B>t*G+a:
        print("No")
      else:
        print("Yes")
  else:
    print("No")

  