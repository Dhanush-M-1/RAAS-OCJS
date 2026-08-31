n = int(input())
x = sorted(list(map(int, input().split())))
y = sorted(list(map(int, input().split())))
z = sorted(list(map(int, input().split())))
for i in range(n):
    try:
        if x[i] != y[i]:
            print(x[i])
            break
    except IndexError:
        print(x[-1])
for j in range(n - 1):
    try:
        if y[j] != z[j]:
            print(y[j])
            break
    except IndexError:
        print(y[-1])
