t=int(input())
from collections import Counter
for _ in range(t):
    n,m=map(int,input().split())
    S=input()
    lengths=list(map(int,input().split()))
    l=[0 for i in range(26)]
    cnt=Counter(lengths)
    prev=1
    times=[]
    for i in range(len(S)-1,-1,-1):
        prev+=cnt[i+1]
        times.append(prev)
    times=times[::-1]
    dic={chr(i):0 for i in range(97,97+26)}
    for i in range(len(S)):
        dic[S[i]]+=times[i]
    ans=[]
    for i in range(97,97+26):
        ans.append(str(dic[chr(i)]))
    print(" ".join(ans))
    

    