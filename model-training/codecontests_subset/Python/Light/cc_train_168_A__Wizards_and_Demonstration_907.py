n,x,y = input().split()
n=int(n)
x=int(x)
y=int(y)

p=(y/100)*n

if(p!=int(p)):
    p=int(p+1)
else:
    p=int(p)

r=p-x
if(r>=0):
    print(r)
else:
    print(0)
