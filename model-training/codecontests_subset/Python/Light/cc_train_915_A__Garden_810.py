n, k = map(int, input().split())
dms = (divmod(k, int(i)) for i in input().split())
result = min(dm[0] for dm in dms if dm[1] == 0)
print(result)
