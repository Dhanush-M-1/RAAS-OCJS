n = int(input())
li1 = list(map(int,input().split()))
li2 = list(map(int,input().split()))
li3 = list(map(int,input().split()))

li1.sort()
li2.sort()
li3.sort()
li2.append(1000000001)
li3.append(1000000001)
for x in range(n):
    if li1[x]!=li2[x]:
        print(li1[x])
        break

for x in range(n-1):
    if li2[x]!=li3[x]:
        print(li2[x])
        break
