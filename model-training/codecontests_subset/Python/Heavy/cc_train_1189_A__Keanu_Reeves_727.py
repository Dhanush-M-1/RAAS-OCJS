n=int(input())
Z=0;
O=0;
s=input().rstrip()
x=list(s)
l=[]
q=[]
w=[]
for i in range(0,len(x)):
    if x[i]=='1':
        O+=1;
    else:
        Z+=1;
if O!=Z or len(x)==1 or (len(x)==2 and x[0]==x[1]):
    print(1)
    print(s)
elif len(x)==2:
    print(2)
    print(x[0],x[1])
else:
    Z=0;
    O=0;
    G=0;
    for i in range(0,len(x)):
        for j in range(i,len(x)):
            t=x[i:j+1]
            if t.count('0')!=t.count('1'):
                g=x[j+1:len(x)]
                if g.count('0')!=g.count('1'):
                    l.append(''.join(t))
                    l.append(''.join(g))
                    G=1;
                    break;
        if G==1:
            break;
    print(2)
    print(l[0],l[1])
