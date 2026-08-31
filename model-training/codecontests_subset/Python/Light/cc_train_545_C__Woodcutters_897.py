N=int(input())
x=[]
h=[]
for i in range(N):
    temp=(input()).split(' ')
    x.append(int(temp[0]))
    h.append(int(temp[1]))
if N<=2:
    print(N)
else:
    ans=2
    for i in range(1,N-1):
        if x[i]-x[i-1]>h[i]:
            ans+=1
        elif x[i+1]-x[i]>h[i]:
            ans+=1
            x[i]+=h[i]
    print(ans)
