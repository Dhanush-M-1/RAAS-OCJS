a, b = input().split()
count = int(input())

alive = set()
alive.add(a)
alive.add(b)
print(' '.join(alive))

for i in range(0,count):
    d, r = input().split()
    alive.remove(d)
    alive.add(r)
    print(' '.join(alive))