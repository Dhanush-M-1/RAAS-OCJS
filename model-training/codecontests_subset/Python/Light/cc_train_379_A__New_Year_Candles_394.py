a,b=map(int,input().split())
c=a
d=a
while c>=b:
    f=c//b
    c=f+c-f*b
    d=d+f
print(d)