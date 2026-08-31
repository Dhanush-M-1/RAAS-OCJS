a, b= map(int,input().split())
y=a//b
yy=a%b
s=a+y
if a<b:
    print(a)
else:
    while y/b>0:
        yy=yy+y%b
        y=y//b
        s=s+y
        if y+yy>=b :
            y=y+yy
            yy=0
        else:
            break
    print(s)