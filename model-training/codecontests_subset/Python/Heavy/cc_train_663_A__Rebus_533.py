s=input()
a=s.split()
n=int(a[-1])
pos=1
neg=0
for item in a:
    if item=='+':
        pos+=1
    if item=='-':
        neg+=1
if n<pos-neg*n or n>pos*n-neg:
    print("Impossible")
else:
    print("Possible")
    parr=[]
    narr=[]
    if pos>neg:
        for i in range(neg):
            narr.append(n)
        x=int(n*(neg+1)//pos)
        for i in range(pos):
            if(i<n*(neg+1)%pos):
                parr.append(x+1)
            else:
                parr.append(x)
    else:
        for i in range(pos):
            parr.append(n)
        x=int(n*(pos-1)//neg)
        for i in range(neg):
            if(i<n*(pos-1)%neg):
                narr.append(x+1)
            else:
                narr.append(x)
    sgn=1
    for c in s:
        if (c=='?'):
            if (sgn==1):
                print(parr[0],end="")
                del parr[0]
            else:
                print(narr[0],end="")
                del narr[0]
            continue
        elif (c=='+'):
            sgn=1
        elif c=='-':
            sgn=-1
        print(c,end="")
