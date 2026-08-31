a=list(map(int,input().split()))
print("Yes" if sum(a)-max(a)==max(a) else "No")