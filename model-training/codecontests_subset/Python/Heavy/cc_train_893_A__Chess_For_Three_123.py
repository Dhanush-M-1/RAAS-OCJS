n=int(input())
a=[]
for i in range(0,n):
    a.append(int(input()))
flag=None
c=0
if(n==1 and a[0]==3):
    print("NO")
else:
    for i in range(0,len(a)):
        if(a[i]==1 and flag==None):
            flag=2
        elif(a[i]==2 and flag==None):
            flag=1
        elif(a[i]==2 and flag==1):
            flag=3
        elif(a[i]==1 and flag==2):
            flag=3
        elif(a[i]==1 and flag==3):
            flag=2
        elif(a[i]==2 and flag==3):
            flag=1
        elif(a[i]==3 and flag==2):
            flag=1
        elif(a[i]==3 and flag==1):
            flag=2
        else:
            c=1
            break
    
    
    if(c==0):
        print("YES")
    else:
        print("NO")
    