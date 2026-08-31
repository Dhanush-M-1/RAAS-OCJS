t=int(input())
for s in range(t):
    n=int(input())
    add=0
    flag=0
    while True:
        if(n==1):
            flag=6
            break
        q=n%3

        if(q!=0):
            flag=0
            break
        n=n//3
        add += 1
    plus=0
    if(flag==0):
        while True:
            if(n==1):
                flag=6
                break
            q=n%2
            if(q!=0):
                flag=0
                break
            plus+=1
            n=n//2
        else:
            flag=0
    if(flag==6 and add>=plus):
        sol=plus+(add-plus)*2
        print(sol)
    else:
        print(-1)