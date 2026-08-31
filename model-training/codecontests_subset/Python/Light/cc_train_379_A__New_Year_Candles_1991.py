a,b=map(int,input().split())
new=a//b
left=a%b
ultimatesum=a+new
while new>0:
    new2=new+left
    new=new2//b
    left=new2%b
    ultimatesum+=new
print(ultimatesum)