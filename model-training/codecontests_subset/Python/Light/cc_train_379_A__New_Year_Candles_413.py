s = list(map(int,input().split()))
count=0
while s[0] !=0:
    s[0]-=1
    count+=1
    if count%s[1]==0:
        s[0]+=1
print(count)