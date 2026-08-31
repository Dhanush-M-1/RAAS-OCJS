def arr_inp():
    return [int(x) for x in input().split()]


n = int(input())
a, b, c = [sorted(arr_inp()) for i in range(3)]
flag1, flag2 = n - 1, n - 2
for i in range(n - 1):
    if a[i] != b[i]:
        flag1 = i
        break
for i in range(n - 2):
    if b[i] != c[i]:
        flag2 = i
        break
print(a[flag1], b[flag2], sep='\n')
