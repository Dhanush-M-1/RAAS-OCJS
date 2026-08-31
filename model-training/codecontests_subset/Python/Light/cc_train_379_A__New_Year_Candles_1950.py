p=input()
p=p.split()
a=int(p[0])
b=int(p[1])
c=0
while a>0:
    c=c+1
    if c%b==0:
        a=a+1
    a=a-1
print(c)