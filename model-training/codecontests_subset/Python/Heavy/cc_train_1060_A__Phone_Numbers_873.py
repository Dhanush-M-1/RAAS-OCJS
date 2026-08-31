n=int(input())
s=input().rstrip()
x=list(s)
l=[]
i=0;
Y=0;
while(i<len(x)):
    if x[i]=='8':
        l.append(x[i])
        del(x[i])
    else:
        i+=1;
if len(l)==0:
    print(0)
else:
    while(1):
        if len(l)==0 or len(x)+len(l)<10:
            break;
        else:
            del(l[0])
            if len(x)+len(l)<10:
                break;
            elif len(x)>=10:
                for i in range(0,10):
                    del(x[0])
                Y+=1;
            elif len(x)<10 and len(l)+len(x)>=10:
                G=len(x)
                for i in range(0,len(x)):
                    del(x[0])
                t=11-G-1
                for i in range(0,t):
                    del(l[0])
                Y+=1;
            else:
                break;
    print(Y)
    
