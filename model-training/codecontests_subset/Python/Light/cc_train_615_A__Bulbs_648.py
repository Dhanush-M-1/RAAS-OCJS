n,m=map(int,input().split())
temp=[]
for i in range(n):
    list=[int(i) for i in input().split()]
    temp+=list[1:list[0]+1]
if(len(set(temp))==m):
    print("YES")
else:
    print("NO")