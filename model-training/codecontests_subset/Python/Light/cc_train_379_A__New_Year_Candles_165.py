x,y=map(int,input().split())
c=x
k=x
while k>=y:
    if k%y==0:
        k=k//y
        c+=k
    else:
        i=k%y
        k=k//y 
        c+=k
        k+=i
print(c) 