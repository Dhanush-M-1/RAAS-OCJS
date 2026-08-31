n,k = map(int,input().split())
same = []
different_a = []
different_b = []
for i in range(n):
    t,x,y = map(int,input().split())
    if x==1 and y==1:
        same.append(t)
    elif x==1 and y==0:
        different_a.append(t)
    elif y==1 and x==0:
        different_b.append(t)

flag=1
if len(same)+len(different_a)<k or len(same)+len(different_b)<k:
    flag=0

if flag==0:
    print(-1)

else:
    same.sort()
    for i in range(1,len(same)):
        same[i]+=same[i-1]
    different_a.sort()
    for i in range(1,len(different_a)):
        different_a[i]+=different_a[i-1]
    different_b.sort()
    for i in range(1,len(different_b)):
        different_b[i]+=different_b[i-1]

    i = 0
    minn = 10**15
    while i<=k:
        ans1 = 10**15
        if i-1>=0 and i-1<len(same):
            ans1=same[i-1]

        ans2=10**15
        if k-i-1>=0 and k-i-1<len(different_a):
            ans2 = different_a[k-i-1]

        ans3 = 10**15
        if k-i-1>=0 and k-i-1<len(different_b):
            ans3= different_b[k-i-1]

        ans=0
        if i==0:
            ans+= ans2+ans3
        elif i==k:
            ans+= ans1
        else:
            ans+=ans1+ans2+ans3
        minn = min(ans,minn)
        i+=1

    print(minn)
