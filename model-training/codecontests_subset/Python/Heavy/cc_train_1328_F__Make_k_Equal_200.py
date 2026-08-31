arr=dict()
zerolock=[True for i in range(51)]

n,k=input().split()
n=int(n)
k=int(k)
data=list(map(lambda x:int(x),input().split()))
for cc in data:
    if len(arr.get(cc, []))==0:
        arr[cc]=[0]
    else:
        arr[cc].append(0)
count=0
while 1:
    count+=1
    for i in range(n):
        data[i] = data[i] >> 1
        cc=data[i]
        if len(arr.get(cc, [])) == 0:
            arr[cc] = [count]
            if cc==0: zerolock[i]=False
        elif cc!=0:
            arr[cc].append(count)
        elif zerolock[i]:
            arr[cc].append(count)
            zerolock[i]=False
    if sum(data)==0:
        break
ans = -1
for c in arr.values():
    if len(c) >= k:
        tempans = 0
        for i in range(k):
            tempans += c[i]
        if ans != -1:
            ans = min(ans, tempans)
        else:
            ans = tempans
print(ans)




