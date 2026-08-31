a = ["Even", "Odd"]
b, c = [int(e) for e in input().split()]
print(a[b * c % 2])