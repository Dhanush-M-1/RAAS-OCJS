a = input().split()
print(*a)
for i in range(int(input())):
    b = input().split()
    a[a.index(b[0])] = b[1]
    print(*a)