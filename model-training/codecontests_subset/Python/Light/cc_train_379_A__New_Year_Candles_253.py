a,b=map(int,input().split())
h=a
x=a//b
while x>0:
    x=a//b
    h+=x
    a=a%b+x
print(h)

