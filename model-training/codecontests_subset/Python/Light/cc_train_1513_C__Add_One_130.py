from sys import stdin
input = stdin.readline

mod = 10**9 + 7
cnt = [1]*(2*10**5+15)
curr = [1,0,0,0,0,0,0,0,0,0]
curr_len = 1
for i in range(2*10**5 + 15):
    cnt[i]=curr_len
    curr_len = (curr_len + curr[-1])%mod
    curr[0] = (curr[0]+curr[-1])%mod
    curr.insert(0,curr.pop())

for _ in range(int(input())):
    n,m = map(int,input().split())
    ans=0
    for i in str(n):
        ans=(ans+cnt[int(i)+m])%mod
    print(ans)