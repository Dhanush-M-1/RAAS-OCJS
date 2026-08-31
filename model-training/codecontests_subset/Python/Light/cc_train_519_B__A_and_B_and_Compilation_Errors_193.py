n = input()
data1 = sorted(map(int, input().split()))
data2 = sorted(map(int, input().split()))
data3 = sorted(map(int, input().split()))

a, b = data1[-1], data2[-1]
for i in range(len(data2)):
    if data1[i] != data2[i]:
        a = data1[i]
        break 
        
for i in range(len(data3)):
    if data2[i] != data3[i]:
        b = data2[i]
        break 
print(a)
print(b)