import math
n,p,w,d=list(map(int,input().split()))
def gcd(a,b):
    if(a==0):
        return (b,0,1)
    d,x1,y1 = gcd(b%a,a)
    return d,y1-(b//a)*x1,x1
g,x,y=gcd(w-d,w)

if(p<w):
    if(p%d == 0):
        y = p//d
        z = n-y
        print(0,y,z)
    else:
        print(-1)
elif(p==w):
    x=1
    z=n-x
    print(x,0,z)
else:
    if(n*w-p<0 or (n*w-p)%g):
        print(-1)
    else:
        x*=(n*w-p)//g
        y*=(n*w-p)//g
        #print('x_0:',x)
        #print('y_0:',y)

        while(True):
            aa=math.floor(x/w)
            x-=aa*w
            y+=(w-d)*aa
            #print('x :',x)
            #print('y :',y)
            if(x>=0 and y>=0):
                if(not (n-x-y>=0)):
                    print(-1)
                    break
                else:
                    print(n-x-y,x,y)
                    break



        #print('x_1:',x)
        #print('y_1:',y)

        #if(x>=0 and y>=0):
        #    print(n-x-y,x,y)
        #else:
        #    print(n-x-y,x,y)
        #    print(-1)