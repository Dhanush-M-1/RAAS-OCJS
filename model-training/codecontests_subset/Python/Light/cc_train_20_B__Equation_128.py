import math
coefficients=input().split()
a=int(coefficients[0])
b=int(coefficients[1])
c=int(coefficients[2])
if (a==0 and b==0 and c==0):
    print(-1)
elif (b**2)-4*a*c<0 or (a==0 and b==0):
    print(0)
elif a==0:
    print(1)
    print("%.10f"%(-c/b))
else:
    root1=(-b-math.sqrt((b**2)-4*a*c))/(2*a)
    root2=(-b+math.sqrt((b**2)-4*a*c))/(2*a)
    min_root=min(root1,root2)
    max_root=max(root1,root2)
    if (b**2)-4*a*c==0:
        print(1)
        print("%.10f"%root1)
    else:
        print(2)
        print("%.10f"%min_root)
        print("%.10f"%max_root)
