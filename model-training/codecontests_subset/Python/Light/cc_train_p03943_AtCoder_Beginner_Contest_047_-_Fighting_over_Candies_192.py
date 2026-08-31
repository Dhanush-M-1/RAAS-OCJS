l = list(map(int,input().split()))
print("Yes" if sum(l)-max(l)==max(l) else "No")