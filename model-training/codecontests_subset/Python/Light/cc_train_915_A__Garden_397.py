n,k=map(int,input().split(' '))
a=list(map(int,input().split(' ')))
value=1000000000000
for i in (a):
    if k%i==0:
        b=int(k/i)
        if value>b:
            value=b
print(value)   
        
    
