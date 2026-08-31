a = input().split()
x = int(input())
print(' '.join(a))
for i in range(x):
    x = input().split()
    a[a.index(x[0])] = x[1]
    print(' '.join(a))