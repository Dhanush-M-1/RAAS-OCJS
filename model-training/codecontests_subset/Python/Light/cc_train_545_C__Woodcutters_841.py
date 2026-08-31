t = int(input())
dp = [0] * t
lis = []
for _ in range(t):
    x, y = [int(i) for i in input().split()]
    lis.append([x,y])
count = min(2,t)
prev = lis[0][0]
for i in range(1,t-1):
    after = lis[i+1][0]
    height = lis[i][1]
    if (lis[i][0] - height) <= prev:
        prev = lis[i][0]
        if lis[i][0] + height < after:
            count += 1
            prev = lis[i][0] + height
    else:
        count += 1
        prev = lis[i][0]
print(count)
