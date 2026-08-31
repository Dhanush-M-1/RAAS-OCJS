r1,r2=[int(x) for x in input().split()]
c1,c2=[int(x) for x in input().split()]
d1,d2=[int(x) for x in input().split()]
count=0
for i in range(1,10):
    if count==1:
        break
    a=i
    for j in range(1,10):
        if count==1:
            break
        b=j
        
        for k in range(1,10):
            if count==1:
                break
            c=k 
            for l in range(1,10):
                d=l
                if r1==a+b and r2==c+d and c1==a+c and c2==b+d and d1==a+d and d2==c+b:
                    count=1 
                    break
if count==0:
    print(-1)
if count==1 :
    if len(set([a,b,c,d]))==4:
        print(a,b)
        print(c,d)
    else:
        print(-1)