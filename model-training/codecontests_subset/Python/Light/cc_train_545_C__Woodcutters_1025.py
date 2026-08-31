import sys
n=int(input())
l=[]
for i in range(n):
    x,y=map(int,input().split())
    l.append([x,y])
if(n<=2):
    print(n)
    sys.exit(0)
ans=2
for i in range(1,n-1):
    if((l[i][0]-l[i][1])>l[i-1][0]):
        ans+=1
    elif((l[i][0]+l[i][1])<l[i+1][0]):
        ans+=1
        l[i][0]+=l[i][1]
    else:
        continue
print(ans)


