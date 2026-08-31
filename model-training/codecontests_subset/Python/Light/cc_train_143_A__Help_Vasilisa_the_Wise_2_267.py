import math

r = list(map(int, input().split()))
c = list(map(int, input().split()))
d = list(map(int, input().split()))

x3 = math.ceil((c[0] + d[1] - r[0])/2)
x1 = c[0] - x3
x2 = d[1] - x3
x4 = r[1] - x3
#print(x1,x2)
#print(x3,x4)
if (x3 > 9) or (x1 > 9) or (x2 > 9) or (x4 > 9) or (x3 <= 0) or (x1 <= 0) or (x2 <= 0) or (x4 <= 0):
    print(-1)
    #print(0)
elif x3 == x1 or x3 == x2 or x3 == x4 or x1 == x2 or x1 == x4 or x2 == x4 :
    print(-1)
    #print(1)
elif (x1+x2) != r[0] or (x3+x4) != r[1] or (x1+x3) != c[0] or (x2+x4) != c[1] or (x1 + x4) != d[0] or (x2 + x3) != d[1] :
    print(-1)
else:
    print(x1,x2)
    print(x3,x4)
