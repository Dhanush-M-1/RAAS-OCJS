a=input()
b=input()
c=input()
l1=[0 for x in range(26)]
l2=[0 for x in range(26)]
l3=[0 for x in range(26)]
for i in range(len(a)):
    l1[ord(a[i])-97]+=1
for i in range(len(b)):
    l2[ord(b[i])-97]+=1
for i in range(len(c)):
    l3[ord(c[i])-97]+=1

sf=""
f1=0
f2=0
k=0
lf=len(a)
while(k<lf):
    df1=100000
    df2=100000
    d1=0
    d2=0
    for i in range(26):
        if(l2[i]>0):
            d1=l1[i]-l2[i]
            df1=min(d1,df1)
        if(l3[i]>0):
            d2=l1[i]-l3[i]
            df2=min(d2,df2)
        if d1<0:
            f1=1
        if d2<0:
            f2=1
    
    if(f1==1 and f2==1):
        while(k<lf):
            for m in range(26):
                if(l1[m]>0):
                    sf=sf+chr(m+97)
                    k+=1
                    l1[m]-=1
    elif(df1>df2 and f1!=1):
        sf+=b
        for m in range(26):
            l1[m]=l1[m]-l2[m]
        k+=len(b)
    else:
        sf+=c
        for m in range(26):
            l1[m]=l1[m]-l3[m]
        k+=len(c)
print(sf)
