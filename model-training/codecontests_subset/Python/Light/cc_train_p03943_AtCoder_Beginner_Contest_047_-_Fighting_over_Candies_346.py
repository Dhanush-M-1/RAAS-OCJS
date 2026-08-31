a=list(sorted(map(int,input().split()))[::-1])
print("Yes" if a[0]==a[1]+a[2] else "No")