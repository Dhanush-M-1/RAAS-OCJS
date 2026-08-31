n = int(input())
line1 = [int(x) for x in input().split()]
line2 = [int(x) for x in input().split()]
line3 = [int(x) for x in input().split()]
line1.sort()
line2.sort()
line3.sort()
a = 0
b = 0
line2.append(-1)
line3.append(-1)
line3.append(-1)
for i in range(n):
    if(line2[i] != line1[i]):
        a = line1[i]
        break
for i in range(n):
    if(line3[i] != line2[i]):
        b = line2[i]
        break
print(a)
print(b)
