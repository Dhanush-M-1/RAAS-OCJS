from collections import Counter


def check(a, b, m):
    ans = b-a
    if ans>=0:
        return b-a
    else:
        return m-a+b

    



n, m = [int(i) for i in input().split(' ')]
arr1 = [int(i) for i in input().split(' ')]
arr2 = [int(i) for i in input().split(' ')]
cnt1 = Counter(arr1)
cnt2 = Counter(arr2)
freq_count = Counter(cnt1.values())
mn = min(freq_count.keys(), key = lambda i:freq_count[i])
req1 = None
for i in cnt1:
    if cnt1[i] == mn:
        req1 = i
        break
req2 = [i for i in cnt2 if cnt2[i] == mn]


ansarr = []
for i in req2:
    ansarr.append(check(req1, i, m))
ansarr.sort()
ans = 10**9
for k in ansarr:
    cnt3 = Counter([(arr1[i]+k)%m for i in range(n)])
    if cnt3==cnt2:
        ans = k
        break
    
print(ans)
