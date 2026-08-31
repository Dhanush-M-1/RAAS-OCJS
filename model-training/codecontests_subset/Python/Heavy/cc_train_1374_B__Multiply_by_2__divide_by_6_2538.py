outputs=[]
for __ in range(int(input())):
    n=int(input())
    if n == 1:
        outputs.append(0)
    else:
        d={}
        i=2
        req=True
        while i*i<=n:
            if i!=2 and i!=3:
                req=False
                break
            while n%i==0:
                d[i]=d.get(i,0)+1
                n=n//i
            i+=1
        if n==1:
            pass
        elif n==2:
            d[2]=d.get(2,0)+1
        elif n==3:
            d[3] = d.get(3, 0) + 1
        else:
            req=False
        if req  and d.get(2,0)<=d.get(3,0):
            outputs.append(d.get(3,0)+(d.get(3,0)-d.get(2,0)))
        else:
            outputs.append(-1)

for output in outputs:
    print(output)




