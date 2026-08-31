n,x,y=map(int,input().split())
z=n*(y*0.01)
m=z-int(z)
if m<0.00000000001:
    if z>x:
        print(int(z-x))
    else:
        print("0")
else:
    if (z+1)>x:
        print(int(z+1-x))
    else:
        print("0")
        
