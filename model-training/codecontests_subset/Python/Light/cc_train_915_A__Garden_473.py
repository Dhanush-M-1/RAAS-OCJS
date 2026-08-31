buckets, garden = map(int, input().split())
lst = [int(x) for x in input().split()]
ans=[]
for i in lst:
    if garden%i==0:
        ans.append(i)
print(int(garden/max(ans)))
