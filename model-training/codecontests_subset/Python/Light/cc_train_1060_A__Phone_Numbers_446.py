N = int(input())
S = str(input())
cnt = 0
for i in range(N):
    if S[i]=='8':
        cnt += 1
print(min(cnt,N//11))
