def xor(a,b,n):
    c=0
    y1=a
    y2=b
    x1=''
    x2=''
    x3=''
    f1=True
    f2=True
    while f1:
        x1=str(a%2)+x1
        a=int(a/2)
        if a==0:
            f1=False
    while f2:
        x2=str(b%2)+x2
        b=int(b/2)
        if b==0:
            f2=False
    d=len(x1)-len(x2)
    if d>0:
        x2='0'*d+x2
    else:
        x1='0'*abs(d)+x1   
    for k in range(len(x1)):
        if x1[k]==x2[k]:
            x3=x3+'0'
        else:
            x3=x3+'1'
    for l in range(len(x3)):
        c=int(x3[-(l+1)])*(2**l)+c
    s=n%3
    if s==0:
        return(y1)
    elif s==1:
        return(y2)
    else:
        return(c)
    
t=int(input())
for o in range(t):
    v=input().split()
    a=int(v[0])
    b=int(v[1])
    n=int(v[2])
    print(xor(a,b,n))