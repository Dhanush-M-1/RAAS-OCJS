
a = int(input())
li1= list(map(int, input().split()))
li2 = list(map(int, input().split()))
li3 = list(map(int, input().split()))
li2.sort()
li1.sort()
li3.sort()
for i in range(a-1):
    if li1[i] != li2[i]: print(li1[i]); break
else: print(li1[-1])
for i in range(a-2):
    if li2[i] != li3[i]: print(li2[i]); break
else: print(li2[-1])
