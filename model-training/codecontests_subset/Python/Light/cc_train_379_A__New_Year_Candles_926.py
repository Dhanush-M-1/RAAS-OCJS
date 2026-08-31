a, b = (int(x) for x in input().split())
n = a + a //(b-1)
print((n, n-1)[a%(b-1) < 1])