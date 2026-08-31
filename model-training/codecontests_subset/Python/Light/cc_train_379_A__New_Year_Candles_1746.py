a,b=map(int,input().split())
d=0
i=1
while a>0:
    a-=1
    d+=1
    if d==b*i:
        a+=1
        i+=1
print(d)


    
    
    
