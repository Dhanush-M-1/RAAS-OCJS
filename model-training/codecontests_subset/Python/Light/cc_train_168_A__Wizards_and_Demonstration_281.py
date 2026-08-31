n,x,y=map(int,input().split( ))
m=(n*y/100)
if m!=m//1:
    m=(m//1)+1
if m>x:
    print(int(m)-x)
else:
    print(0)
    
