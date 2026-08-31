a,b=map(int,input().strip().split(' '))
s=a
if(a>=b):
    p=1
else:
    p=0
while(a>=b):
   
    p=a//b
    w=a%b
    s+=p
    a=p+w
    
print(s)
    
         