n, m = map(int, input().split())
count1 = count2 = 0
while n != 0:
    n -= 1
    count1 += 1
    count2 += 1
    if count2 == m:
        n += 1
        count2 = 0
print(count1)