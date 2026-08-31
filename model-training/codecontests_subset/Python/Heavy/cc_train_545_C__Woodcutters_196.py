n = int(input())

a = []

for i in range(n):
    k, v = [int(c) for c in input().split()]
    a.append((k,v))


total = 0
lastOccupied = a[0][0]
for i in range(n):
    if i == 0 or i == n-1:
        total +=1
    else:
        #try to the left
        if a[i][0] - a[i][1] > lastOccupied:
            total += 1
            lastOccupied = a[i][0]
        else:
            if a[i][0] + a[i][1] < a[i+1][0]:
                total += 1
                lastOccupied = a[i][0] + a[i][1]
            else:
                lastOccupied = a[i][0]

print(total)


