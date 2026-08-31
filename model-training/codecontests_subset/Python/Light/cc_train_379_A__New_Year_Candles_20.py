n=input().split()
a=int(n[0])
b=int(n[1])
x=0
y=0
while 1<=a<=1000 and 2<=b<=1000:
    x=x+1
    a=a-1
    y=y+1
    if y==b:
        a=a+1
        y=0
print(x)
