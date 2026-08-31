s=input()
a=0
b=0
c=0
for i in range(0,len(s)):
    if(s[i]=='1'):
        a+=1
    if(s[i]=='2'):
        b+=1
    if(s[i]=='3'):
        c+=1
k=a+b+c
 
for i in range(0,k):
    if(i<a):
        if(i==k-1):
            print("1",end=""),
        else:
            print("1+",end=""),
    elif(i<a+b):
        if(i==k-1):
            print("2",end=""),
        else:
            print("2+",end=""),
    else:
        if(i==k-1):
            print("3",end=""),
        else:
            print("3+",end=""),
