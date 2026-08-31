



t=[]
hi=[]
u=2
n=int(input())
for j in range(n):
    x,h = map(int,input().split())
    t.append(x)
    hi.append(h)




if n==1:
    print(1)
elif n==2:
    print(2)
else:


    for j in range(1,n-1):
        if t[j]-t[j-1]>=hi[j]+1:
            u+=1    
        else:
            if t[j+1]-t[j]>=hi[j]+1:
                u+=1
                t[j]=t[j]+hi[j]
                    

    print(u)
    
