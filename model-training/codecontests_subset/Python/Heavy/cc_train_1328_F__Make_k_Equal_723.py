n,k = map(int,input().split());
arr = list(map(int,input().split()));
tarr = [];
for i in range(n):
    t = arr[i];
    while(t>=1):
        tarr.append(t);
        t = t//2;
ans = 10**9 + 7;   
for i in tarr:
    cnt = [];
    for j in range(n):
        t = arr[j];
        cnt1 = 0;
        while(t//2>=i):
            cnt1+=1;
            t = t//2;
        if(t==i):
            cnt.append(cnt1);
    cnt.sort();
    if(len(cnt)>=k):
        ans=min(ans,sum(cnt[0:k]))
print(ans);

        
        
