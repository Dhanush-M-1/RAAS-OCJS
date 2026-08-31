a = sorted(list(map(int,input().split())))
print("Yes" if a.pop()==sum(a) else "No")