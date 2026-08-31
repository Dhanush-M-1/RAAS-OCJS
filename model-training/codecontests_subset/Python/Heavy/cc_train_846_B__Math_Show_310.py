n,k, M = map(int,input().split())
time_list = sorted(list(map(int,input().split())))
sum1 = sum(time_list)
tries_list = []
for i in range(n+1):
    m = M
    c = 0
    for j in range(i):
        if m - sum1 >= 0:
            m -= sum1
            c += k + 1
        else:
            break
    for j in range(k):
        for _ in range(n-i):
            if m - time_list[j] >= 0:
                m -= time_list[j]
                c += 1
            else:
                break
    tries_list.append(c)
print(max(tries_list))       
    