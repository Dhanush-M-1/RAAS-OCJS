a, b =map(int, input().split())
x = (a//b)*b
y = 0
while(a>=b):
    y=y+a%b
    a=a//b+a%b   
    x=x+(a//b)*b    
print(x+a)


