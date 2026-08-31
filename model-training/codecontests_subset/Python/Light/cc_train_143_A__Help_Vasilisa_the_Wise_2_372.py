r1,r2 =map(int, input().split())

c1,c2 =map(int, input().split())

d1,d2 =map(int, input().split())


y=0
for i in range(1,d1):
    if i>9:
        break
    b=i 
    x=d1-b
    if x>=1 and x<=9:
        a=c1-x
        if a+b==r2:
            y=r1-x
            z=[x,y,a,b]
            if y>=1 and y<=9 and a>=1 and a<=9 and len(set(z))==4:
                break
            else:
                y=0

if y==0:
    print(-1)
else:
    print(str((x)) + ' ' +str((y)))
    print(str((a))+ ' ' +str((b))) 

    
