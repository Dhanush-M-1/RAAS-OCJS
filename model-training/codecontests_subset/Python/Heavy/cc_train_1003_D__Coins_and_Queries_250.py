
import sys
input = sys.stdin.buffer.readline

n,q=map(int,input().split())
arr=[int(x) for x in input().split()]

ques=[]
for i in range(q):
    ques.append(int(input()))

dp=[0]*31

for i in arr:
    s=bin(i)[2:]
    dp[len(s)-1]=dp[len(s)-1]+1
# print(dp)
for q in ques:
    l=list(bin(q)[2:])
    l=l[::-1]
    # print(l)
    i=len(l)-1
    cnt=0
    ans=0
    while i>=0:
        if l[i]=="1":
            cnt=cnt+1
        
        if dp[i]>=cnt:
            ans=ans+cnt
            cnt=0
        else:
            ans=ans+dp[i]
            cnt=cnt-dp[i]

        cnt=2*cnt
        i=i-1
    if cnt==0:
        print(ans)
    else:
        print(-1)  