a=[int(i) for i in input().split()]
a.sort()
print("Yes" if a[2] == a[0]+a[1] else "No")