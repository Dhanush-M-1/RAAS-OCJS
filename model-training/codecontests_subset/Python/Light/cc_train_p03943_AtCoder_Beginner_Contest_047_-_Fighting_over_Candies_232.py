a=list(map(int,input().split()))
a.sort()
print(["No","Yes"][a[0]+a[1]==a[2]])