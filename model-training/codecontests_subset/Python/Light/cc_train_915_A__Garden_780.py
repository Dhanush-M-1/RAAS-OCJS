n,k=[int(i) for i in input().split()]
x=[int(i) for i in input().split()]
ans=[]
for i in range(0,len(x)):
    if(k%x[i]==0):
        s=k//x[i]
        ans.append(s)
print(min(ans))