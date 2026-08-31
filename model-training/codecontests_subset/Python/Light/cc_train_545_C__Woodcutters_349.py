n=int(input())
f=[];answer=min(2,n)
for i in range(n):
    x,h=map(int,input().split())
    f.append([x,h])
p=f[0][0]
for i in range(1,n-1):
    a=f[i]
    if a[0]-a[1]>p:
        answer+=1
        p=a[0]
    else:
        if a[0]+a[1]<f[i+1][0]:
            answer+=1
            p=a[0]+a[1]
        else:
            p=a[0]
print(answer)