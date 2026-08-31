
I0 = lambda :map(int,input().split())
I1 = lambda :int(input())
I2 = lambda :list(map(int,input().split()))
#####################################################
from math import ceil
for i in range(I1()):
        a,b,n = I0()
        f0 = a
        f1 = b
        if n == 0:print(a);continue
        if n == 1:print(b)
        else:
                yy = a^b
                if ceil((n-2)/3) == int((n-2)/3):
                        print(yy)
                elif ceil((n-3)/3) == int((n-3)/3):
                        print(a)
                else:print(b)

'''
n = I1()
a = I2()
g = dict()
res = list()
for i in range(n):
        if g.get(a[i][0],-1) == -1:
                g[a[i]] = [1,i]
        else:
                l = g[a[i]][1]
                r = i
                res.append(i)
'''