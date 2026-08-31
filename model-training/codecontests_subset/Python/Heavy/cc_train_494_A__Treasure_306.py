x=input()
c=0
d=0
for i in x:
    if i=='(':
        c+=1
    if i==')':
        c-=1
    if i=='#':
        d+=1
if (c<=0) or (d>c) :
    print(-1)
else :
    y=0
    flag=True
    dd=d
    cc=c
    for i in x:
        if(y<0):
            flag=False
            break
        if i=='(':
            y+=1
        if i==')':
            y-=1
        if i=='#':
            if dd>1:
                dd-=1
                cc-=1
                y-=1
            else :
                y-=cc
            
    if(flag):
        while d>1:
            print (1)
            d-=1
            c-=1
        print(c)
    else:
        print(-1)