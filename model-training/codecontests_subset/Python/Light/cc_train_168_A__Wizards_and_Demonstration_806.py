a=list(input().split())
n=int(a[0])
x=int(a[1])
y=int(a[2])
per=(x*100)/n

y=y-per

if y<=0:
    print(0)
else:
    if (y*n/100) - int(y*n/100)==0:
        print(int (y*n/100))
    else:
        print(int((y*n)/100) +1)