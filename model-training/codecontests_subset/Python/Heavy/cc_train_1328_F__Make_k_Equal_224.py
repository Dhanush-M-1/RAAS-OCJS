n,k = map(int,input().split())
l = list(map(int,input().split()))
count = [0]*((2*(10**5)) + 1)
no = [0]*((2*(10**5)) + 1)
ans = float('inf')
l.sort()
for i in l:
    c = 0
    e = 0
    while i>0:
        if no[i]<k:
            count[i]+=c
            no[i]+=1
            c+=1
        i = i//2
            
        if i == 0:
            if no[i]<k:
                count[i]+=c
                no[i]+=1
for i in range(len(count)):
    if no[i]>=k:
        ans = min(ans,count[i])
print(ans)
            
