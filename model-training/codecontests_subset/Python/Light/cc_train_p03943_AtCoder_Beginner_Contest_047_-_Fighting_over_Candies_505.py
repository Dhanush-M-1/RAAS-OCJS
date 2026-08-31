l = sorted(map(int, input().split()))
print(["No","Yes"][l[2]*2==sum(l)])