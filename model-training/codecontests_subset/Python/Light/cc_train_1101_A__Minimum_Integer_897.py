import math


x = int(input())
for i in range(x):
  n1 , n2 , n3 = map(int , input().split())
  i = 2
  if (n3 < n1 and n3 < n2) or  (n3 > n1 and  n3 > n2):
    print(n3)
  if n3 == n2:
    print(2 * n3)
  if n3 >= n1 and n3  < n2:
   print(math.ceil((n2 + 1)/n3) * n3)