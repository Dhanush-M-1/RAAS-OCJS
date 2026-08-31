from sys import stdin, stdout, maxsize


R = lambda : stdin.readline().strip()
RL = lambda f=None: list(map(f, R().split(' '))) if f else list(R().split(' '))

output = lambda x: stdout.write(str(x) + '\n')
output_list = lambda x: output(' '.join(map(str, x)))

M = int(1e9) + 7
mx = int(2e5) + 5

dp =  [0]+9*[1] +[2] + mx*[0]

for i in range(11, len(dp)):
    dp[i] = (dp[i-9] + dp[i-10])%M


for tc in range(int(R())):
    n, m = RL(int)
    ans = 0
    for i in list(str(n)):
        ans = (ans +dp[int(i) + m])%M
    print(ans)