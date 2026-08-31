a,b=input().split()
x=int(a)
a1=int(a)
b1=int(b)
while(a1>=b1):
    x=x+(a1//b1)
    a1=(a1//b1)+(a1%b1)
print(x)    
