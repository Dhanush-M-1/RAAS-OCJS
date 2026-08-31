n = int(input())
a = [int(elem) for elem in input().split()]
ch = []
nec = []
ans = 0
for i in range(n):
    ans += a[i]
    if a[i] % 2 == 0:
        ch.append(a[i])
    else:
        nec.append(a[i])
ch.sort()
nec.sort()
k = min(len(ch), len(nec))
sum1 = 0
sum2 = 0
for i in range(len(ch) - 1, len(ch) - k - 1, -1):
    sum1 += ch[i]
for i in range(len(nec) - 1, len(nec) - k - 1, -1):
    sum2 += nec[i]
if len(ch) - k > 0:
    sum1 += ch[len(ch) - k - 1]
elif len(nec) - k > 0:
    sum2 += nec[len(nec) - k - 1]
print(ans - sum1 - sum2)