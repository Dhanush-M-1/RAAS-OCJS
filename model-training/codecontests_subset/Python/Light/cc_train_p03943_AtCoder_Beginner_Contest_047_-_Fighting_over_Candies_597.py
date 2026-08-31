a=[int(i) for i in input().split()]
print('Yes' if max(a)==sum(a)-max(a) else'No')