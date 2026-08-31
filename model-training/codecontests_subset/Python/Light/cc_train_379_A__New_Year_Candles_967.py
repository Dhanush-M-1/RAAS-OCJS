a,b=map(int,input().split())
c,x=a,a
while x>=b:
    c+=(x)//b
    x=x//b+x%b
print(c)    



