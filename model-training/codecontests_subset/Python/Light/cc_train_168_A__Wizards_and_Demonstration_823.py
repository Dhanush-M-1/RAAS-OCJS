import math


data = input().split()

#data = open('inputs.txt', 'r').read().split()
n = int(data[0])
x = int(data[1])
y = int(data[2])

#print("%d | %d | %d"% (n, x, y))

demo = math.ceil((y*n)/100)
if(demo<x):
   print(0)
else:
   res = abs(x-demo)
   print(res)