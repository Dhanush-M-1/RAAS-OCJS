input()

count1 = 0
for i in input().split(" "):
    count1 += int(i)

count2 = 0
for i in input().split(" "):
    count2 += int(i)

count3 = 0
for i in input().split(" "):
    count3 += int(i)

print(count1 - count2)
print(count2 - count3)