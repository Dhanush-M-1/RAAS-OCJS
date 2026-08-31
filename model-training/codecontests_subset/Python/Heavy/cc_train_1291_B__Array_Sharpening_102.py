from sys import stdin
t=int(stdin.readline().strip())
par=["2","0","4","8","6"]
for caso in range(t):
    n=int(stdin.readline().strip())
    s=list(map(int,stdin.readline().strip().split()))
    can=[False for i in range(n+10)]
    can1=[False for i in range(n+10)]
    x=0
    can[n]=True
    for i in range(n-1,-1,-1):
        if s[i]>=x:
            can[i]=True
        else:
            break
        x+=1
    x=0
    for i in range(n):
        if s[i]>=x:
            can1[i]=True
        else:
            break
        x+=1

    if can[0]:
        print("Yes")
        continue
    flag=False
    for i in range(n):
        if can[i+1] and can1[i] and s[i]>(n-2-i):
            flag=True
            break
    if flag:
        print("Yes")
    else:
        print("No")
        

        
