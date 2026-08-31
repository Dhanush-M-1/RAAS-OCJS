import sys, math

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
odd = []
even = []
for i in range(1, n + 1, 2):
    j = i
    temp = []
    while j <= n:
        temp.append(j)
        j += 2
    if len(temp) == len(arr):
        odd.append(temp)

for i in range(2, n + 1, 2):
    j = i
    temp = []
    while j <= n:
        temp.append(j)
        j += 2
    if len(temp) == len(arr):
        even.append(temp)

ans = 9876543210
for i in odd:
    temp = 0
    for j in range(len(arr)):
        temp += abs(i[j] - arr[j])
    ans = min(temp, ans)
for i in even:
    temp = 0
    for j in range(len(arr)):
        temp += abs(i[j] - arr[j])
    ans = min(temp, ans)
print(ans)