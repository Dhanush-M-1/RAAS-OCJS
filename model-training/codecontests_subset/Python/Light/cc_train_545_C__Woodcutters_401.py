n=int(input())
a=[]
b=[]
for i in range(n):
    inp=input().split()
    a.append(int(inp[1]))
    b.append(int(inp[0]))
if n>=2:    
    count=2
elif n==1:
    count=1
for i in range(1,n-1):
    if (b[i]-b[i-1])>a[i]:
        count+=1
    else:
        if (b[i+1]-b[i])>a[i]:
            count+=1
            b[i]=b[i]+a[i]
        else:
            continue

print(count)
