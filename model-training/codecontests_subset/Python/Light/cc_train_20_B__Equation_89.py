from math import *
a,b,c = input().split()
a,b,c = int(a),int(b),int(c)
d_2 = (b**2) - (4 * a * c)
if d_2 < 0:
    print("0")
elif a == 0 and b == 0:
    if c == 0:print("-1")
    else:print('0')
elif a == 0 and b != 0:
    print("1")
    x_1 = -(float(c)/float(b))
    print("%.10f" % x_1)
else:
    if d_2 == 0:
        print('1')
        print('%.10f' % (-b/(2*a)))
        exit()
    print("2")
    x_small = float((-float(b) - sqrt(d_2)))/float(2 * a)
    x_big = float((-float(b) + sqrt(d_2)))/float(2 * a)
    print("%.10f" % min(x_small,x_big) + '\n' + "%.10f" % max(x_big,x_small))

