a,b=map(int,input().split())
d=a
while a>=b:
   d=d+a//b
   a=a//b+a%b
print(d)
