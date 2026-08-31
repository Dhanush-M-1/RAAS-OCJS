n=int(input())
ls=[]
for i in range(n):
    x,h=map(int,input().split())
    ls.append([x,h,0])
ans=0
for i in range(n):
    if(i==0):
        ans+=1
    elif(i==n-1):
        ans+=1
    else:
        if(ls[i-1][2]==0):
            if(ls[i-1][0]<ls[i][0]-ls[i][1]):
                ans+=1
            elif(ls[i][0]+ls[i][1]<ls[i+1][0]):
                ans+=1
                ls[i][2]=1
        else:
            if(ls[i-1][0]+ls[i-1][1]<ls[i][0]-ls[i][1]):
                ans+=1
            elif(ls[i][0]+ls[i][1]<ls[i+1][0]):
                ans+=1
                ls[i][2]=1
print(ans)                