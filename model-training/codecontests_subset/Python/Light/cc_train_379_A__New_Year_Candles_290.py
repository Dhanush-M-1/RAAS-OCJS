a,b=map(int,input().split())
c,p=0,0
while True:
    if(a==0):
        break
    a-=1
    c+=1
    p+=1
    #print(a,b,c)
    if c==b:
        c=0
        a+=1
print(p)
