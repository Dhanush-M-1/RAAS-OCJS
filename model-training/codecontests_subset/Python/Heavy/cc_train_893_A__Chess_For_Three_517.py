n=int(input())
a=[]
curr=3
flag=0
for i in range(n):
    a.append(int(input()))
for i in range(n):
    if(a[i]==curr):
        flag=1
        break
    else:
        if(a[i]==1):
            if(curr==2):
                curr=3
            else:
                curr=2
        elif(a[i]==2):
            if(curr==1):
                curr=3
            else:
                curr=1
        else:
            if(curr==2):
                curr=1
            else:
                curr=2
if(flag):
    print("NO")
else:
    print("YES")

