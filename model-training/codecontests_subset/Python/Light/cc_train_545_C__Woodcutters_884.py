#Woodcutters
n=int(input())
l=[]
for i in range(n):
    l.append((tuple(map(int,input().split()))))
if n<=2:
    print(n)
else:
    right=False
    ans=2
    for j in range(1,len(l)-1):
        if l[j][0]-l[j][1]>l[j-1][0]+right:
            right=False
            ans+=1
        elif l[j][0]+l[j][1]<l[j+1][0]:
            right=l[j][1]
            ans+=1
        else:
            right=False
    print(ans)