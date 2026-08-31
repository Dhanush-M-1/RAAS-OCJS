n, m = map(int, input().split())
d = n*m//(m-1)
print(d - (d % m == 0))
