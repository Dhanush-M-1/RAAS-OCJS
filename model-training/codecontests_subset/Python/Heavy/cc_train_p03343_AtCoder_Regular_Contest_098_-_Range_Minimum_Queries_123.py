n, k, q = map(int, input().split())
a = list(map(int, input().split()))

result = 100000000000
for j in range(n):
    li = [[]]
    for i in range(n):
        if a[j] <= a[i]:
            li[-1].append(a[i])
        else:
            li.append([])
    ans = []
    for li_ele in li:
        if len(li_ele) < k:
            continue
        else:
            tmp = sorted(li_ele)
            ans = ans + tmp[0:len(li_ele)-k+1]
    ans = sorted(ans)
    if len(ans) >= q:
        result = min(ans[q-1] - a[j], result)
print(result)