from collections import defaultdict

for _ in range(int(input())):
    n,m = map(int,input().split())
    s = str(input())
    pos = list(map(int,input().split()))
    pos.sort()
    ansdic,curdic = defaultdict(int),defaultdict(int)
    j = -1
    for i in pos:
        if(i-1!=j):
            for k in range(j+1,i):
                curdic[s[k]] += 1
        for c,d in curdic.items():
            ansdic[c] += d
        
        j = i-1
    
    for i in s:
        ansdic[i] += 1
    
    ans = ['0']*26
    for i,j in ansdic.items():
        ans[ord(i)-97] = str(j)
    print(' '.join(ans))