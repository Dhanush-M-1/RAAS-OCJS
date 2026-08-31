k = int(input().split()[1])
for a in sorted(map(int, input().split()), reverse=True):
    if not (k % a):
        break
print(k // a)