a=int(input())
for i in range(0,a):
    flag=0
    b=list(map(int,input().split()))
    if(b[0]//b[2]>=1):
        if(b[0]%b[2]==0 and b[0]//b[2]==1):
            flag=0
        else:
            m=b[2]
            flag=1
    if(flag==0):
        if(b[1]%b[2]==0):
            m=b[1]+b[2]
        else:
            m=b[1]+b[2]-b[1]%b[2]
    print(m)
