buttons, lamps = map(int, input().split())
a = []
for i in range(buttons):
    a += map(int, input().split()[1:])
if len(set(a)) == lamps:
    print("YES")
else:
    print("NO")