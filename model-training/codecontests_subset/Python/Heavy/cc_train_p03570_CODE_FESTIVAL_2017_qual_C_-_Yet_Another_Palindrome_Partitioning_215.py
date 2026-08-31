alphabetlist=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
alpha={moji:alphabetlist.index(moji) for moji in alphabetlist}

s=input()
N=len(s)
data=[0]
for i in range(N):
    data.append(2**alpha[s[i]])

for i in range(1,N+1):
    data[i]^=data[i-1]

que={val:2*N for val in data}

dp=[2*N]*(N+1)
dp[0]=0
que[0]=0
S=set([2**i for i in range(26)])
S.add(0)
for i in range(1,N+1):
    for j in S:
        k=data[i]^j
        if k in que:
            dp[i]=min(dp[i],que[k]+1)
    que[data[i]]=min(que[data[i]],dp[i])

print(dp[-1])
