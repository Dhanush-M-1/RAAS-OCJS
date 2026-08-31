n, k = (int(x) for x in input().split())
print(min([k // int(x) for x in input().split() if k % int(x) == 0]))
