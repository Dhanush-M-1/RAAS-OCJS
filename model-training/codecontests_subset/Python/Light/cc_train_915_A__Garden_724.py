b=list(map(int,input().split()))
n=b[0]
k=b[1]
a=list(map(int,input().split()))
a.sort(reverse=True)
for i in range(0,n):
    if k%a[i]==0:
        print(int(k/a[i]))
        break
    else:
        continue
