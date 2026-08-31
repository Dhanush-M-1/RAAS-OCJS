#from time import time
#s=time()
def get_primes():
  n = 10**6
  m = n+1
  numbers = [True] * m
  for i in range(2, int(n**0.5 + 1)):
    if numbers[i]:
      for j in range(i*i, m, i):
        numbers[j] = False
  primes = set()
  for i in range(2, m):
    if numbers[i]:
      primes.add(i)
  return primes


n=int(input())

from math import sqrt
from itertools import combinations
primes = get_primes()

def product(lis):
    ans=1
    for each in lis: ans*=each
    return ans

def factorise(x):
    maxans = x
    pro = x
    di = {}
    while x != 1:
        for each in primes:
            while x % each == 0:
                x = x // each
                di[each] = 1 if each not in di else di[each]+1
            if x==1:
                break
        if x != 1:
            di[x] = 1
            break
    groups = []
    for each in di:
        groups.append(each**di[each])
    if len(groups) == 1:
        return groups[0]
    maxans = product(groups)
    for k in range(1, len(groups)):
        for perm in combinations(groups, k):
            a = product(list(perm))
            b = pro // a
            maxans = min(maxans, max(a,b))
    return maxans

ans = factorise(n)

print(n//ans, ans)
#print(time()-s)