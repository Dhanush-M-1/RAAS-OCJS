a = list(map(int,input().split()))
print(["No","Yes"][sum(a)==2*max(a)])