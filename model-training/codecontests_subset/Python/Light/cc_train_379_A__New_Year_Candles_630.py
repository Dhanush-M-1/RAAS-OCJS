a,b=[int(i) for i in input().split()]
s=a
while(1):
    s=int(s+a/b)
    a=int((a/b)+(a%b))
    if(a<b):
        break
print(int(s))
    
    