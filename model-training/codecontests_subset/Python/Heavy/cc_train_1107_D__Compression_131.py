import math
n = int(input())
arr = []
for i in range(n):
    x = bin(int(input(), 16))[2:]
    arr.append('0' * (n - len(x)) + x)

arr.append("fe")
count = 1
mini = 0
store1=[]
for i in range(n):
    if (arr[i] == arr[i + 1]):
        count += 1
    else:
        store1.append(count)
        count = 1
store2 = []
length = 1
for i in range(1,n):
    flag = True
    for j in range(n):
        if arr[j][i-1] != arr[j][i]:flag = False
    if flag: length += 1
    else: store2.append(length);length = 1
store2.append(length)
ans1 = store1[0]
for x in store1:
    ans1 = math.gcd(ans1, x)
ans2 = store2[0]
for y in store2:
    ans2 = math.gcd(ans2, y)
print(math.gcd(ans1,ans2))
