n, k = map(int, input().split())
a = list(map(int, input().split()))
cnt = [[] for i in range(2*10**5 + 10)]

for num in a:
    tmp_cnt = 0
    while True:
        if num == 0:
            cnt[num].append(tmp_cnt)
            break
        else:
            cnt[num].append(tmp_cnt)
            num = num // 2
            tmp_cnt += 1

ans = 10**9 + 7
for cnt_i in cnt:
    if len(cnt_i) < k:
        continue
    else:
        cnt_i = sorted(cnt_i)
        ans = min(ans, sum(cnt_i[0:k]))
print(ans)