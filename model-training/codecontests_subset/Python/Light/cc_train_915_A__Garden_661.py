n, k = map(int, input().split())
a = list(input().split())
output = 0
for i in range(len(a)):
    if k % int(a[i]) == 0:
        if output == 0:
            output = k // int(a[i])
        else:
            output = min(output, k // int(a[i]))
print(output)