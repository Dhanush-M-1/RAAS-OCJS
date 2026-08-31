a, b = map ( int, input().split() )
chasov=0
b1=b
while a>0:
    a=a-1
    chasov=chasov+1
    if chasov==b1:
        a=a+1
        b1=b1+b
print(chasov)
