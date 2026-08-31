a=list(map(int,input().split()))
print(['No','Yes'][max(a)==sum(a)-max(a)])