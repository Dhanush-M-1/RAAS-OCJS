ak=int(input())
for i in range(ak):
    dh=input()
    alpha=input()
    beta=alpha.split(' ')
    x=[int(beta[i]) for i in range(len(beta))]
    a=[-1 for i in range(len(x))]
    MAXIN=0
    for i in range(len(x)):
        if x[i]==len(x):
            MAXIN=i
            break
        else:
            pass
    a[MAXIN]=0
    k=len(x)-1
    addition=0
    while k!=0:
        maxi=-1
        index=-1
        addition+=1
        for i in range(len(x)):
            if a[i]!=-1 and i!=0 and index!=-1:
                a[index]=addition
                maxi=0
                index=-1
                k-=1
            elif a[i]!=-1 and i==0:
                index=-1
            elif a[i]!=-1 and index==-1:
                pass
            elif i==len(x)-1 and maxi<x[i]:
                a[i]=addition
                k-=1
            elif i==len(x)-1 and maxi>x[i] :
                a[index]=addition
                k-=1
            elif maxi<x[i]:
                maxi=x[i]
                index=i
            else :pass
    s=''
    for i in range(len(a)):
        s=s+str(a[i])+' '
    print(s)