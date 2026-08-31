n = int(input())
array = input().split(' ')

even = []
odd = []
for i in range(n):
    if int(array[i]) % 2 == 0:
        even.append(int(array[i]))
    else:
        odd.append(int(array[i]))

if abs(len(even) - len(odd)) > 1:
    if len(even) > len(odd):
        even.sort()
        for x in range(len(odd) + 1):
            del even[len(even) - 1]
        sam = 0
        for y in range(len(even)):
            sam += even[y]
        print(sam)
    else:
        odd.sort()
        for x in range(len(even) + 1):
            del odd[len(odd) - 1]
        sam = 0
        for y in range(len(odd)):
            sam += odd[y]
        print(sam)
else:
    print(0)

