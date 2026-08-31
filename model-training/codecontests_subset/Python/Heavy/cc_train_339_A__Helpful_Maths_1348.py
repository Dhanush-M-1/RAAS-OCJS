n=input()
l=len(n)
o=0
t=0
th=0
if(l==1):
    print(n)
else:
    for i in range(l): 
        b=n[i]
        if(i%2==0):
            if(b=='1'):
                o+=1
            elif(b=='2'):
                t+=1
            elif(b=='3'):
                th+=1
    a=''
    for i in range(o-1):
        a=a+'1+'
    if(t==0 and th==0 and o!=0):
        a=a+'1'
    elif(o!=0):
        a=a+'1+'
    for i in range(t-1):
        a=a+'2+'
    if(th==0 and t!=0):
        a=a+'2'
    elif(t!=0):
        a=a+'2+'
        
    for i in range(th-1):
        a=a+'3+'
    if(th!=0):
        a=a+'3'
    print(a)