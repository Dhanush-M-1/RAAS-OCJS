import math
N=list(input())
K=int(input())
ans=0
not_zero=0
def cmb(n, r):
  if n-r>=1 and n>=1 and r>=1: 
    return math.factorial(n) // (math.factorial(n - r) * math.factorial(r))
  elif n==r or n==r:
    return 1
  elif r==0:
    return 1
  else:
    return 0
for i in range(len(N)):
  if N[i]!="0":
    ans+=cmb(len(N[i+1:]),K-not_zero) * (9**(K-not_zero))
    ans+=cmb(len(N[i+1:]), K-not_zero-1) *(int(N[i])-1)* (9**(K-not_zero-1))
    not_zero+=1
    #print(ans)
    if not_zero==K:
      ans+=1
      break
print(ans)
  