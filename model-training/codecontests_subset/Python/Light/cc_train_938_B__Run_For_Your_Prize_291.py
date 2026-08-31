n = int(input())

li = list(map(int,input().split()))

a = float('inf')
ind = 0

for i in range(n):

    if abs(li[i]-500000.5)<a:
        ind = i
        a = abs(li[i]-500000.5)


if li[ind]<500000.5:
    print(li[ind]-1)


else:
    print(1000000-li[ind])








