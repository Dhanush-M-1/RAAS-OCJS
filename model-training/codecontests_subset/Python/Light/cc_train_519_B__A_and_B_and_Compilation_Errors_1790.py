initi = int(input())
data1 = [int(i) for i in input().split()]
data2 = [int(i) for i in input().split()]
data3 = [int(i) for i in input().split()]
data1.sort()
data2.sort()
data3.sort()
flag = True
for i in range(initi - 1):
    if(data1[i]!=data2[i]):
        print(data1[i])
        flag = False
        break
if flag:
    print(data1[initi - 1])
flag = True
for i in range(initi - 2):
    if(data2[i]!=data3[i]):
        print(data2[i])
        flag = False
        break
if flag:
    print(data2[initi - 2])
