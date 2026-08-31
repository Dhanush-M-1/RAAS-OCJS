from collections import defaultdict


n = int(input())
all_errs = list(map(int, input().split()))
errs_minus_one = list(map(int, input().split()))
errs_minus_two = list(map(int, input().split()))

err2freq_all = defaultdict(int)
err2freq1 = defaultdict(int)
err2freq2 = defaultdict(int)
for i in range(n):
    if i != n-1:
        err2freq1[errs_minus_one[i]] += 1
    if i != n-1 and i != n-2:
        err2freq2[errs_minus_two[i]] += 1
    err2freq_all[all_errs[i]] += 1

err1 = ''
for k, v in err2freq_all.items():
    if k not in err2freq1 or v != err2freq1[k]:
        err1 = k
        break
if err1 == '':
    raise Exception('Nothing set for err1')

err2 = ''
for k, v in err2freq1.items():
    if k not in err2freq2 or v != err2freq2[k]:
        err2 = k
        break
if err2 == '':
    raise Exception('Nothing set for err2')

print(err1)
print(err2)
