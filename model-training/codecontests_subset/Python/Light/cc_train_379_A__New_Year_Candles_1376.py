a = list(map(int, input().split()))
i = 1
while a[0]>0:
    if i % a[1] == 0:
        a[0] = a[0] + 1
    a[0] = a[0] - 1
    i = i + 1
print(i - 1)






