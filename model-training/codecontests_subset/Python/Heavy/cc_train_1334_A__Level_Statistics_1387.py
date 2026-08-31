t=int(input())
for _ in range(t):
    n=int(input())
    p=[0]*n
    c=[0]*n
    for i in range(n):
        p[i],c[i]=map(int,input().split())
    #print(p,c)

    i=0
    flag=0
    if(n==1 and p[0]>=c[0]):
        print('yes')
        continue

    #c[n]=max(c)
    #print(c)
    while(p[i]>=c[i] and c[i+1]>=c[i] and p[i+1]>=p[i]):
        if(c[i+1]-c[i] > p[i+1]-p[i]):
            break
        if i==n-2:
            flag=1
            break

        i+=1

    if(flag and p[n-1]>=c[n-1]):
        print('yes')
    else:
        print('no')
