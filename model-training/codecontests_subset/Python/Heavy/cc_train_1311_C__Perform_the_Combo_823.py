import sys
t=int(sys.stdin.readline())
for _ in range(t):
    n,m=map(int,sys.stdin.readline().split())
    s=sys.stdin.readline()[:-1]
    temp=[0]*26
    dic=[temp]
    for i in range(n):
        temp=[i for i in dic[-1]]
        temp[ord(s[i])-97]+=1
        dic.append(temp)
    #print(dic,'dic')
    p=list(map(int,sys.stdin.readline().split()))
    ans=[0]*26
    for i in range(len(p)):
        for j in range(26):
            ans[j]+=dic[p[i]][j]
    #print(ans,'ans')
    for i in range(26):
        ans[i]+=dic[-1][i]
    print(*ans)
