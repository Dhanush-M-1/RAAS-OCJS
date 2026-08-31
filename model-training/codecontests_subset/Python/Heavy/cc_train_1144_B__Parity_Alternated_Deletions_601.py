n=int(input())
O=[]
E=[]
OO=[]
EE=[]
p=input().rstrip().split(' ')
for i in range(0,len(p)):
    if int(p[i])%2==0:
        E.append(int(p[i]))
        EE.append(int(p[i]))
    else:
        O.append(int(p[i]))
        OO.append(int(p[i]))
if len(E)+1==len(O) or len(O)+1==len(E) or len(O)==len(E):
    print(0)
else:
    O.sort(key=int,reverse=True)
    OO.sort(key=int,reverse=True)
    E.sort(key=int,reverse=True)
    EE.sort(key=int,reverse=True)
    i=0;
    while(len(O)!=0 or len(E)!=0):
        if i%2==0:
            if len(O)!=0:
                i+=1;
                del(O[0])
            else:
                break;
        else:
            if len(E)!=0:
                i+=1;
                del(E[0])
            else:
                break;
    G=0;
    while(len(OO)!=0 or len(EE)!=0):
        if G%2==0:
            if len(EE)!=0:
                G+=1;
                del(EE[0])
            else:
                break;
        else:
            if len(OO)!=0:
                G+=1;
                del(OO[0])
            else:
                break;
    S=0;
    D=0;
    for i in range(0,len(O)):
        S=S+int(O[i])
    for i in range(0,len(E)):
        S=S+int(E[i])
    for i in range(0,len(OO)):
        D=D+int(OO[i])
    for i in range(0,len(EE)):
        D=D+int(EE[i])
    print(min(S,D))
