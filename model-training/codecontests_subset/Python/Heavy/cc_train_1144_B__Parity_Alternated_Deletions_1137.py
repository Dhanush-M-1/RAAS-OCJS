n=int(input())
a=input().split()
b1=[]
c1=[]
b2=[]
c2=[]
sum1=0
sum2=0
for i in range(n):
    if(int(a[i])%2==0):
        b1.append(int(a[i]))
        b2.append(int(a[i]))
    else:
        c1.append(int(a[i]))
        c2.append(int(a[i]))
    sum1+=int(a[i])    
    sum2+=int(a[i])
b1.sort(reverse=True)
c1.sort(reverse=True)
d=0
while len(b1)>0 and len(c1)>0:
    if d%2==0:
        sum1-=b1[0]
        b1.pop(0)
        d+=1
    else:
        sum1-=c1[0]
        c1.pop(0)
        d+=1
if d%2==0 and len(b1)>0 and len(c1)==0:
    sum1-=b1[0]
    b1.pop(0)
elif d%2!=0 and len(b1)==0 and len(c1)>0:
    sum1-=c1[0]
    c1.pop(0)
b2.sort(reverse=True)
c2.sort(reverse=True)        
e=0        
while len(b2)>0 and len(c2)>0:
    if e%2==0:
        sum2-=c2[0]
        c2.pop(0)
        e+=1
    else:
        sum2-=b2[0]
        b2.pop(0)
        e+=1
if e%2==0 and len(b2)==0 and len(c2)>0:
    sum2-=c2[0]
    c2.pop(0)
elif e%2!=0 and len(b2)>0 and len(c2)==0:
    sum2-=b2[0]
    b2.pop(0)        
print(min(sum1,sum2))