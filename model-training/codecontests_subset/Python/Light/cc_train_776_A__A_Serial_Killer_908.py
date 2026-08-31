a,b=input().split()
print(a,b)
for i in range(int(input())):
    c,d=input().split()
    if(c==a):
        x=d
        y=b
        print(x,y)
    else:
        x=a
        y=d
        print(x,y)
    a=x
    b=y
    
               
    
