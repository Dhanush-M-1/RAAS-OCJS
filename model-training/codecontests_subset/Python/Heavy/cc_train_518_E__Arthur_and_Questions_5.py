import sys

n, k = map(int, input().split())
a = input().split()
INF = 10 ** 9 + 7
OK = True

for i in range(n):
    if a[i] == "?":
        a[i] = INF
    else:
        a[i] = int(a[i])

for i in range(len(a)):
    if a[i] == INF:
        j = i + k
        while j < len(a) and a[j] == INF:
            j += k
        count = (j - i) // k
        if i - k >= 0:
            left = a[i - k]
        else:
            left = - INF
        if j < len(a):
            right = a[j]
        else:
            right = INF
        if right < INF and left > -INF and right - left <= count:
            print("Incorrect sequence")
            OK = False
            break
        if left >= -1:
            a[i: j: k] = [left + g + 1 for g in range(count)]
        elif right <= 1:
            a[i: j: k] = [right - count + g for g in range(count)]
        else:
            if - left < right:
                c1 = min(- left - 1, count // 2)
                new = [- c1 + g for g in range(count)]
            else:
                c2 = min(right - 1, count // 2)
                new = [c2 - count + 1 + g for g in range(count)]
            a[i: j: k] = new

if OK:
    for i in range(n - k):
        if a[i] >= a[i + k]:
            print("Incorrect sequence")
            OK = False
            break

if OK:            
    print(" ".join(map(str, a)))