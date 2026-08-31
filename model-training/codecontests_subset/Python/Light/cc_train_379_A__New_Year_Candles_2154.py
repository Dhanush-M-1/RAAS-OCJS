a,b=map(int,input().split())
c=0
while a>0:
    a=a-b+1
    c+=b
print (c+a-1)