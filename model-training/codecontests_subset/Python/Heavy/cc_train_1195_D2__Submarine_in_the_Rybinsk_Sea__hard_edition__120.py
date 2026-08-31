n = int(input())
num = input().rstrip().split(" ")

ans = 0
length = [0 for _ in range(11)]
for k in num:
    length[len(k)] += 1
for i in num:
    check = len(i)
    for j in range(11):
        if check <= j:
            for l in range(check):
                ans += 11*length[j]*int(i[check-l-1])*pow(10, (2*l), 998244353)
                ans %= 998244353
        else:
            count = 0
            for u in range(check-(check-j)):
                ans += 11*length[j]*int(i[check-u-1])*pow(10, count, 998244353)
                count += 2
                ans %= 998244353
            for v in range(check-(check-j),check):
                ans += 2*length[j]*int(i[check-v-1])*pow(10, count, 998244353)
                count += 1
                ans %= 998244353

print(ans)