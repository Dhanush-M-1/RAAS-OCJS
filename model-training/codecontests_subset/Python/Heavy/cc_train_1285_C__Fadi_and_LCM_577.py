from itertools import combinations
from functools import reduce
 
def getPrimeFactors(a):
   factors = []
   for i in range(2, int((a**.5))+2):
      val = 1
      while a%i == 0:
         a//=i
         val*=i
      if val != 1: factors.append(val)
   return factors
 
a = int(input())
factors = getPrimeFactors(a)

factors.append(1)

 
m = (float("inf"), float("inf"))

for x in range(1, 7):
   comb = combinations(factors, x)
   for i in comb:
      ans = reduce((lambda x,y:x*y), i)
      b = a//ans
      m = min(m, (max(ans, b), min(ans, b)))
      
print(str(m[1]) + " " + str(m[0]))
 
