a,b=list(map(int,input().split()))
l=[]
c=a
while a>=b:
    q=a//b
    c+=q
    r=a%b
    a=q+r
    
 
print(c)   