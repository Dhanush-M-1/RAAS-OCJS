a , b = [int(x) for x in input().split()]
count = a
while(a >= b):
  count += int(a / b)
  a = int(a / b) + int(a % b)
print(count)  
