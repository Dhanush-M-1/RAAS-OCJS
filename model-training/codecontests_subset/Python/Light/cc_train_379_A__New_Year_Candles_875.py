a,b=map(int,input().split())
h=a
c=0
while a+c>=b:
    
    
    

    d=(a+c)%b
    a=int((a+c)/b)
    h+=a
    c=d

print(h)