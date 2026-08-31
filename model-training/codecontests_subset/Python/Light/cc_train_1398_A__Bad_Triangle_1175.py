t = int(input())
ans = []
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    if a[0] + a[1] <= a[-1]:
        ans.append([0, 1, len(a)-1])
    else:
        ans.append(-1)
for i in range(t):
    if type(ans[i]) is list:
        for j in ans[i]:
            print(j+1, end=' ')
        print()
    else:
        print(ans[i])