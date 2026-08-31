a = int(input())

st = str(input())
if (a < 11):
    print(0)
    exit()
map = {}

for i in range(10):
    map[i]=0

for i in range(a):
    map[int(st[i])] += 1

if map[8] == 0:
    print(0)
    exit()
ans = 0

print(min(int(a / 11),map[8]))