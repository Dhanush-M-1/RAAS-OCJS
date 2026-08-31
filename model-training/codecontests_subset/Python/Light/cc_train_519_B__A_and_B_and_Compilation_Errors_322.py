we = int(input())
data1 = [int(x) for x in input().split()]
data2 = [int(y) for y in input().split()]
data3 = [int(z) for z in input().split()]
data1, data2, data3 = sorted(data1), sorted(data2) + [0], sorted(data3) + [0, 0]

for iten1 in range(we):
    if data1[iten1] != data2[iten1]:
        print(data1[iten1])
        break

for iten2 in range(we):
    if data2[iten2] != data3[iten2]:
        print(data2[iten2])
        break
