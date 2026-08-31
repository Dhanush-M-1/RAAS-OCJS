n = int(input())
prizes = list(map(int, input().split()))
time1 = 0
time2 = 0
present = 0
previous = 1
for i in range(n):
    if prizes[i] > 500000:
        break
    present = prizes[i]
    time1 += (present - previous)
    previous = present
previous = 1000000
for j in range(n - 1, -1, -1):
    if prizes[j] <= 500000:
        break
    present = prizes[j]
    time2 += (previous - present)
    previous = present
print (max(time2, time1))
