r = list(map(int,input().strip().split()))
c = list(map(int,input().strip().split()))
d = list(map(int,input().strip().split()))
a11 = (r[0]+c[0]-d[1])/2
a12= r[0]-a11
a21 = c[0]-a11
a22 = d[0]-a11
if (a11 != a12 and a11 != a21 and a11 != a22 and a12 != a21 and a12 != a22 and a21 != a22 and a11 >= 1 and a11 <= 9 and a12 >= 1 and a12 <= 9 and a21 >= 1 and a21 <= 9 and a22 >= 1 and a22 <= 9 and a21 + a22 == r[1] and a12 + a22 == c[1] and a12 + a21 == d[1]):
    print("{} {}\n".format(int(a11),int(a12)))
    print("{} {}\n".format(int(a21),int(a22)))
else:
    print("-1")
