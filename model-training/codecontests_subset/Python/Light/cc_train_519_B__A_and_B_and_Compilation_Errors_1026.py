n = int(input())
lis1 = [int(i) for i in input().split()]
lis2 = [int(i) for i in input().split()]
lis3 = [int(i) for i in input().split()]
lis1.sort()
lis2.sort()
lis3.sort()
c=0
for i in range(0,n-1):
    if lis1[i] != lis2[i]:
        print(lis1[i])
        c = c+1
        break
if c==0:
    print(lis1[n-1])
c=0
for i in range(0,n-2):
    if lis2[i] != lis3[i]:
        print(lis2[i])
        c = c + 1
        break
if c==0:
    print(lis2[n-2])