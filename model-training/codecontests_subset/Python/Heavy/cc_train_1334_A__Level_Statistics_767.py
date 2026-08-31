a=int(input())
for i in range(a):
    flag=0
    s=int(input())
    ma1=0
    ma2=0
    ans=[]
    q=0
    r=0
    for i in range(s):
        x,y=map(int,input().split())
        ans.append([x,y])
    for i in range(len(ans)):
        if(ans[i][0]-q<0):
            flag=1
            break;
        if(ans[i][1]-r<0):
            flag=1
            break;
        if(ans[i][0]-q<ans[i][1]-r):
            flag=1
            break;
        else:
            q=ans[i][0]
            r=ans[i][1]
    
    if(flag==0):
        print('YES')
    else:
        print('NO')
