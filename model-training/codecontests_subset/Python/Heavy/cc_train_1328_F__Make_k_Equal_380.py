import sys
input = sys.stdin.readline

n, k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
a.sort()

for i in range(n-k+1):
    if a[i] == a[i+k-1]:
        print(0)
        sys.exit(0)

l = r = m = 0
# suppose val is the number where k numbers are the same
# case 1, turn the leftmost k numbers to val (or val-1)
for i in range(k-1):
    l += a[k-1] - a[i]
for i in range(k-1, n-1):  # if a[k-1] have many same numbers
    if a[i] == a[i+1]:
        l -= 1
    else:
        break

# case 2, turn the rightmost k numbers to val (or val-1)
a_reverse = a[::-1]
for i in range(k-1):
    r += -(a_reverse[k-1] - a_reverse[i])
for i in range(k-1, n-1):
    if a_reverse[i] == a_reverse[i+1]:
        r -= 1
    else:
        break

# case 3, all the numbers are val or val-1 or val+1
for i in range(n//2):
    m += a[n-i-1] - a[i]
m -= n - k
print(min(l, r, m))