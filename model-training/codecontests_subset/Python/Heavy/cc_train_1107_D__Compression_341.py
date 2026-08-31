import math
ans=0
def string(s,n):
    j=''
    for i in range(n//4):
        if s[i]=='0' :
            j=j+'0000'
        elif s[i]=='1' :
            j=j+'0001'
        elif s[i]=='2' :
            j=j+'0010' 
        elif s[i]=='3' :
            j=j+'0011' 
        elif s[i]=='4' :
            j=j+'0100' 
        elif s[i]=='5' :
            j=j+'0101'
        elif s[i]=='6' :
            j=j+'0110'
        elif s[i]=='7' :
            j=j+'0111'
        elif s[i]=='8' :
            j=j+'1000'
        elif s[i]=='9' :
            j=j+'1001'
        elif s[i]=='A' :
            j=j+'1010'
        elif s[i]=='B' :
            j=j+'1011'
        elif s[i]=='C' :
            j=j+'1100'
        elif s[i]=='D' :
            j=j+'1101'
        elif s[i]=='E' :
            j=j+'1110'
        elif s[i]=='F' :
            j=j+'1111'
          
    
    return j                                        
  
n=int(input(''))
a=[]
x=1
ansx=set()
ansy=set()
for i in range(n):
    s=input('')
    a.append(string(s,n))
j=0
k=a[0]
c=1
for i in range(1,n):
    if k==a[i]:
        c+=1
        if i==n-1:
            ansy.add(c)
    else:
        if c==1:
            print('1')
            exit()
        ansy.add(c)
        c=1
        k=a[i]
for i in range(n):
    k=a[i][0]
    c=1
    for j in range(1,n):
        if k==a[i][j]:
            c+=1
            if j==n-1:
                ansx.add(c)
        else:
            if c==1:
                print('1')
                exit()
            ansx.add(c) 
            k=a[i][j]
            c=1
ansx=list(ansx)
ansy=list(ansy)
#print(ansx,ansy,a)
my=min(ansy)
mx=min(ansx)
ans=0
for i in range(len(ansx)):
    if math.gcd(ansx[i],mx)==1:
        ans=-1
#print(ans,mx,my)        
if ans==0:
    for i in range(len(ansy)):
        if math.gcd(ansy[i],my)==1:
            ans=-1
#print(ans,mx,my)            
if ans==-1 : 
    print('1')
else:
    print(math.gcd(mx,my))
        