import math

a, b = list(map(int, input().split()))

hrs = a

while a >= b:
    a = a/b
    #print(a)
    hrs += a

#print((a/b)+hrs)
#print(round(hrs))

if (a/b)+hrs >= math.floor(hrs)+1:
    print (math.floor((a/b)+hrs))
else:
    print(math.floor(hrs))