hm, bulbs = input().split(" ")
hm = int(hm)
bulbs = int(bulbs)
lis = []

for i in range(1, bulbs+1):
    lis.append(i)

for i in range(hm):
    num = input().split(" ")
    leng = len(num)
    for j in range(leng):
        if (j == 0):
            continue
        num[j] = int(num[j])
        if num[j] in lis:
            lis.remove(num[j])

if len(lis) == 0:
    print("YES")
else:
    print("NO")
