n, k = map(int, input().split())
a = []
b = []
ab = []
for i in range(n):
    t, a1, b1 = map(int, input().split())
    if a1 == 1 and b1 == 1:
        ab.append(t)
    elif a1 == 1 and b1 == 0:
        a.append(t)
    elif a1 == 0 and b1 == 1:
        b.append(t)
a.sort()
a_i = 0
b.sort()
ab.sort()
ab_i = 0
sum_t = 0
count = 0
while count < k:
    if (a_i == len(a) or a_i == len(b)) and ab_i < len(ab):
        sum_t += ab[ab_i]
        ab_i += 1
    elif ab_i == len(ab) and a_i < len(a) and a_i < len(b):
        sum_t += a[a_i] + b[a_i]
        a_i += 1
    elif ab_i < len(ab) and a_i < len(a) and a_i < len(b):
        if a[a_i] + b[a_i] < ab[ab_i]:
            sum_t += a[a_i] + b[a_i]
            a_i += 1
        else:
            sum_t += ab[ab_i]
            ab_i += 1
    else:
        sum_t = -1
        break
    count += 1

print(sum_t)