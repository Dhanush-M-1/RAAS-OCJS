import math
a, b, c=input().split()
a=int(a)
b=int(b)
c=int(c)
if ((a!=0 and b*b<4*a*c) or (a==b==0 and c!=0)): print ('0')
elif (a==b==c==0): print('-1')
elif (a==0):
        print('1')
        a1=-c/b
        print (format(a1, '.5f'))
else:
    a1=(-b-(b*b-4*a*c)**.5)/(2*a)
    a2=(-b+(b*b-4*a*c)**.5)/(2*a)
    if a1<a2: a1,a2=a2,a1
    if (a1!=a2):
        print('2')
        print (format(a2, '.5f'))
        print (format(a1, '.5f'))
    else:
        print('1')
        print (format(a1, '.5f'))
