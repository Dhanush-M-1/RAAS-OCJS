n=int(input())
s=input()
a=0
f=0
j=0
for i in s:
    if(i=="A"):
        a=a+1
    elif(i=="F"):
        f=f+1
    else:
        j=j+1
z=0
if(a!=0 and j==0):
    z=z+a
if(j==1):
    z=z+j
print(z)