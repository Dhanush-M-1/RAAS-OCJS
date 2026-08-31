for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    f=0
    a,b=l[0],l[1]
    for i in range(2,n):
       if  a+b<=l[i]:
           f=1
           break
    if f==1:
        print(1,2,i+1)
    else:
        print(-1)
