import sys
f = sys.stdin.read().split()
names = f[:2]
n = int(f[2])
print('{} {}'.format(f[0],f[1]))
for i in range(n):
    killed, new  = f[3+i*2 : 3+(i+1)*2]
    names[names.index(killed)] = new
    print('{} {}'.format(*names))
