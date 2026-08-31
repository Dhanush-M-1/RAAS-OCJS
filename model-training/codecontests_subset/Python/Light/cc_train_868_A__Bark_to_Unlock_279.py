pas=input()
n=int(input())
x=0
y=0
flag=0
for i in range(n):
    a=input()
    if(a[1]==pas[0]):
        x=1
    if(a[0]==pas[1]):
        y=1
    elif(a[0]==pas[0] and a[1]==pas[1]):
        flag=1
if((x==1 and y==1) or flag==1):
    print ('YES')
else:
    print ("NO")