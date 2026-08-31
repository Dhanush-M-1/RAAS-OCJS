n = int(input())

data = [[0,0]] * n

for i in range(n):
    data[i] = [int(d) for d in input().split()]

if n>1:
    count = 2
else:
    count = 1

left_barrier = data[0][0]
for i in range(1, n-1):
    if data[i][0] - data[i][1] > left_barrier:
        count += 1
        left_barrier = data[i][0]
    else:
        if data[i][0] + data[i][1] < data[i+1][0]:
            count += 1
            left_barrier = data[i][0] + data[i][1]
        else:
            left_barrier = data[i][0]
print(count)
