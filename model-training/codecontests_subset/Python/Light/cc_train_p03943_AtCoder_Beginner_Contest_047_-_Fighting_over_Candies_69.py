a=list(map(int,input().split()))
a.sort()
print(['No','Yes'][max(a)-min(a)==a[1]])
