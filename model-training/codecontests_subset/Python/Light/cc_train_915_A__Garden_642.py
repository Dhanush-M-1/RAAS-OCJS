T=list(map(int,input().split()))
q=list(map(int,input().split()))

count=[]
for i in range(T[0]):
    if T[1]%q[i]==0:
        count.append(int(T[1]/q[i]))
count.sort()
print(count[0])
            