n = int(input())
list1 = []
list2 = []
for i in range(n):
    list = input().split()
    list1.append(int(list[0]))
    list2.append(int(list[1]))
count = 0
if n >= 2:
    count = 2
if n == 1:
    count = 1
for i in range(1, n-1):
    left = list1[i-1]  
    right = list1[i+1]
    position = list1[i]
    height = list2[i]
    if position - height > left:
        count += 1
    elif position + height < right:
        count += 1
        list1[i] = list1[i] + height
print(count)