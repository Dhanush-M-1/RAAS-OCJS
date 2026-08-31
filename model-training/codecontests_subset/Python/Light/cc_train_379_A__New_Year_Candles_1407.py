import sys
parametrs = list(map(int, input().split()))
n = parametrs[0]
b = parametrs[1]
hours = n
while(n >= b):
  new_part = n //b
  hours +=new_part
  n = n - new_part * b + new_part
print(hours)
