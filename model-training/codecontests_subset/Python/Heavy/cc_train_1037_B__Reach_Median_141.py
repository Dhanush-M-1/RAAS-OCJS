n,m = map(int,input().split())
lis = list(map(int,input().split()))
lis.sort()
if len(lis)==1:
    print(abs(m-lis[0]))
    exit()

median_index = n//2
median = lis[n//2]
ans=abs(median-m)

if lis[median_index+1] >= m and lis[median_index-1] <=m:
    print(ans)

elif lis[median_index+1]<m:
    ans+=abs(lis[median_index+1]-m)
    median_index+=2
    while median_index<len(lis) and lis[median_index]<m:
        ans += abs(lis[median_index] - m)
        median_index+=1
    print(ans)

elif lis[median_index-1]>m:
    ans+=abs(lis[median_index-1]-m)
    median_index-=2
    while median_index>=0 and lis[median_index]>m:
        ans += abs(lis[median_index] - m)
        median_index-=1
    print(ans)