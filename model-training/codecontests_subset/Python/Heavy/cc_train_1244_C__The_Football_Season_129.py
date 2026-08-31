def extendedEuclid(a, b, x, y):
        if(a == 0):
                x = 0
                y = 1
                return b
 
        x1=[1]
        y1=[1]
 
        ret = extendedEuclid(b % a, a, x1,y1)

        x[0] = y1[0] - (b//a)*x1[0]
        y[0] = x1[0]
        return ret

N,p,w,d=map(int,input().split())
xx=[int(1)]
yy=[int(1)]
if (p>N*w):
	print("-1")
	exit()
a = d
b = w
n = p
gc = extendedEuclid(a,b,xx,yy)
x = xx[0]
y = yy[0]

# print(x,y)


if (n%gc!=0):
        print("-1")
        exit()
else:
        x=x*n//gc
        y=y*n//gc
        t = (b-1-x*gc)//b
        t2=0
        if ((b-a)==0):
                t2 = 1e25
        else:
                t2 = min(gc*y//a, (N-x-y)*gc//(b-a))

        # print(t,t2)

        if (t2<t):
        	print("-1")
        	exit()

        x+=t*b//gc
        y-=t*a//gc

        if (x<0 or y<0):
        	print("-1")
        	exit()
        else:
                X = y
                Y = x
                Z = N-x-y
                print(X,Y,Z)