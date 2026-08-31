a=[int(i) for i in input().split()]
print(["No","Yes"][sum(a)-max(a)==max(a)])