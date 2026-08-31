t=int(input())
while(t):
    n=int(input())
    l=[]
    l=list(map(int,input().split()))
    f=0
    for i in range(len(l)-2):
        if l[i]+l[i+1]<=l[n-1]:
            f=1
            break
        else:
            f=0
    if f==0:
        print(-1)
    else:
        print(i+1,i+2,n)
        



    
    t-=1
