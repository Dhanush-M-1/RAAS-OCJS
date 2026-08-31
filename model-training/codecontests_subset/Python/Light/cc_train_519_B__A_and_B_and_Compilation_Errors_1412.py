n = int(input())

errors = []
for _ in range(3):
    nums = sorted([int(i) for i in input().split()])
    errors.append(nums)

ans = []
idx1, idx2 = 0, 1
for i in range(1, 3):
    found = False
    n1, n2 = errors[idx1], errors[idx2]
    for j in range(n-i):
        if n1[j] != n2[j]:
            found = True
            ans.append(n1[j])
            break

    idx1, idx2 = idx2, idx2 + 1
    if not found:
        ans.append(n1[-1])

for i in ans:
    print(i)
