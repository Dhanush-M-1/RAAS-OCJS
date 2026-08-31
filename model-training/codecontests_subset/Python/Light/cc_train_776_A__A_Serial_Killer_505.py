names = input().split()
n = int(input())

ans = list()
ans.append(names.copy())
for i in range(n):
    old, new = input().split()
    names[names.index(old)] = new
    ans.append(names.copy())

print('\n'.join([' '.join(i) for i in ans]))
