x = list(map(int, input().split()))
x.sort()
print(["No","Yes"][2*x[2]==sum(x)])
