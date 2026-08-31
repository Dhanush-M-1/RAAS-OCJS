a=list(map(int,input().split()))

print("Yes"if max(a)==sorted(a)[-2]+min(a) else"No")