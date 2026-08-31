n=input()
a=[0,0,0]
for i in n:
    if (i=='+'):
        continue
    if (i=='1'):
        a[0]+=1
    elif (i=='2'):
        a[1]+=1
    else:
        a[2]+=1
p=1
for i in range(a[0]+a[1]+a[2]):
    if p==1:
        if (a[0]>0):
            s='1'
            a[0]-=1
        elif (a[1]>0):
            s='2'
            a[1]-=1
        elif(a[2]>0):
            s='3'
            a[2]-=1
        p=0
    else:
        if (a[0]>0):
            s=s+'+1'
            a[0]-=1
        elif (a[1]>0):
            s=s+'+2'
            a[1]-=1
        elif(a[2]>0):
            s=s+'+3'
            a[2]-=1
print(s)
