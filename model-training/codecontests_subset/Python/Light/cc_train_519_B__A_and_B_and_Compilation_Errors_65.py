n = int(input())
arr = list(map(int, input().split()))
a = list(map(int, input().split()))
b = list(map(int, input().split()))

mis = []
dic = {}
dic2 = {}

for i in range(n):
    num = arr[i]
    try:
        dic[num] += 1
    except:
        dic[num] = 1
for num in a:
    dic[num] += 1
    try:
        dic2[num] += 1
    except:
        dic2[num] = 1
    
for num in dic:
    if dic[num]%2 != 0:
        mis.append(num)
        break
for num in b:
    dic2[num] += 1
for num in dic2:
    if dic2[num]%2!=0:
        mis.append(num)
        break
for num in mis:
    print(num)


