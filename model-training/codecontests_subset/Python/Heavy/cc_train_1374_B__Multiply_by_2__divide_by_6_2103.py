t=int(input())
for _ in range(0,t):
    n=int(input())
    a=[]
    a.append(n)
    p=0
    count=0
    while n!=1:
        if n==2 or n==4 or n==5:
            p=1
            break
        else:
            if n%6==0:
                n=n//6
                count+=1
            elif n%3==0:
                n=n*2
                count+=1
            else:
                p=1
                break
        z=n
        if z in a:
            p=1
            break
        else:
            a.append(z)
        
    if p==0:
        print(count)
    else:
        print(-1)
