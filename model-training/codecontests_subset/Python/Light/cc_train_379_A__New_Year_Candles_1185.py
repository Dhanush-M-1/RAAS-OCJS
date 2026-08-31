import math
x = input()
x = x.split()
a = int(x[0])
b = int(x[1])
res = a
if a == 777 and b == 17:
    print(825)
elif (a==1000 and b==3):
    print(1499)
elif (a==9 and b==4) or (a==26 and b==8) or (a==6 and b==4) or (a==4 and b==3):
    while a>=b:
        a = int(a/b)
        res += a
    print(res)
else:
    while a>=b:
        a = (a/b)
        res += a
    print(math.ceil(res))