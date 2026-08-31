n = int(input())
a = [*map(int, input())]
e = a.count(8)
print(min(n//11, e))