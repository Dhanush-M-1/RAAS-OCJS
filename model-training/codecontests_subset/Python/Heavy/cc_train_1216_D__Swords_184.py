n = int(input())
a = [int(_) for _ in input().split()]
shit = max(a)
l1 = []
ans = 0
for i in a:
    if shit - i != 0:
        l1.append(shit - i)
shit = min(l1)
factors1 = []
factors2 = []
for i in range(1, int(shit ** 0.5) + 2):
    if shit % i == 0:
        factors1.append(i)
        factors2.append(shit // i)
for i in factors2 + factors1[::-1]:
    for j in l1:
        if j % i != 0:
            break
    else:
        ans = i
        break
for i in range(len(l1)):
    l1[i] = l1[i] // ans
print(sum(l1), ans)       