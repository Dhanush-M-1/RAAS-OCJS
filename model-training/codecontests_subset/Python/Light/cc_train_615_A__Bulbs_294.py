a, b = map(int, input().split())
c = set()
for i in range(a):
    c.update(input().split()[1:])
print(['NO','YES'][len(c)==b])