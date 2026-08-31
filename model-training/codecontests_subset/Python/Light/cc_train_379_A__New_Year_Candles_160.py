a,b=map(int,input().split())
t=0
m=0
while a>0:
    t+=1
    m+=1
    a-=1
    if m==b:
        m=0
        a+=1
print(t)
            
