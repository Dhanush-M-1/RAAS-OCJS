def binp(a,b):
    st=a[0]
    fin=a[1]
    b=[-b[1],-b[0]]
    while True:
        s=(st+fin)//2
        if s>=b[0]:
            if s<=b[1]:
                return(s)
            else:
                fin=s-1
        else:
            st=s+1
s=input()
for i in range(len(s)):
    if s[i]=='=':
        y=i
        break
y+=1
n=int(s[y:])
now='+'
max_=0
min_=0
ctr=0
pls=0
minus=0
g=[[0,0]]
for i in s:
    ctr+=1
    if i=='?':
        if now=='+':
            max_+=n
            min_+=1
            pls+=1
        else:
            max_-=1
            min_-=n
            minus+=1
        g.append([min_,max_])
    elif i=='-' or i=='+':
        now=i
    elif i=='=':
        break
v=n
if v<min_ or v>max_:
    print('Impossible')
else:
    print('Possible')
    a=[pls*1,pls*v]
    b=[minus*(-v)-n,minus*(-1)-n]
    #print(a,b)
    ctr=0
    ctr=binp(a,b)
    fir=ctr
    j=[0]*pls
    if pls!=0:
        j=[fir//pls]*pls
        for u in range(fir%pls):
            j[u]+=1
    sec=n-ctr
    k=[0]*minus
    if minus!=0:
        k=[((-sec)//minus)]*minus
        #print(k)
        #print((-sec)%minus)
        for u in range((-sec)%minus):
            k[u]+=1
    p=0
    m=0
    now='+'
    for i in s:
        if i=='?':
            if now=='+':
                print(j[p],end='')
                p+=1
            else:
                print(k[m],end='')
                m+=1
        elif i=='-' or i=='+':
            now=i
            print(i,end='')
        else:
            print(i,end='')
    
    
        
    
        
    
    
