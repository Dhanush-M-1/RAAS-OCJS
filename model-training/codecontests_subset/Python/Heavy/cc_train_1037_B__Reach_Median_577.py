n, s = map(int, input().split())
a = list(map(int, input().split()))

operations = 0

a = sorted(a)
median_pos = n // 2
try:
    index = a.index(s)
except:
    index = len(a)
    for idx, val in enumerate(a):
        if val > s:
            if idx <= median_pos: idx -= 1
            index = idx
            break

to_change = []
if median_pos < index:
    to_change = a[median_pos:index]
if median_pos > index:
    to_change = a[index+1:median_pos+1]

operations += abs(sum(to_change) - s * len(to_change))
print(operations)
