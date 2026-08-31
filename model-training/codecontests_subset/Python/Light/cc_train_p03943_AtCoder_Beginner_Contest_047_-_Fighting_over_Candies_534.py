a = sorted(map(int,input().split()))
print("Yes" if sum(a[:2]) == a[2] else "No")
