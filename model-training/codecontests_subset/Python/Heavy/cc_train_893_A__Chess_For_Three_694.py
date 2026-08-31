n=int(input())
a=[]
for i in range(0,n):
    a.append(int(input()))
a1=1
b=1
c=0
flag=0
for i in range(0,len(a)):
    if(a[i]==1 and a1==1):
        if(b==1):
            b=0
            c=1
        elif(c==1):
            c=0
            b=1
        else:
            flag=1
            break
    elif(a[i]==2 and b==1):
        if(a1==1):
            a1=0
            c=1
        elif(c==1):
            c=0
            a1=1
        else:
            flag=1
            break
    
    elif(a[i]==3 and c==1):
        if(b==1):
            b=0
            a1=1
        elif(a1==1):
            a1=0
            b=1
        else:
            flag=1
            break
    else:
        flag=1
        break
if(flag==0):
    print("YES")
else:
    print("NO")