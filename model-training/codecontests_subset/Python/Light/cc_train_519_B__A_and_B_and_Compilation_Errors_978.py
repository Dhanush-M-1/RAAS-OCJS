from sys import stdin, exit
import collections

n = int(stdin.readline())
fst = stdin.readline().rstrip().split(' ')
snd = stdin.readline().rstrip().split(' ')
thrd = stdin.readline().rstrip().split(' ')

fc = collections.defaultdict(int)
sc = collections.defaultdict(int)
tc = collections.defaultdict(int)

for num in fst:
    fc[num] += 1
    
for num in snd:
    sc[num] += 1
    
for num in thrd:
    tc[num] += 1
    
for key, value in fc.items():
    if sc[key] != value:
        print(key)

for key, value in sc.items():
    if tc[key] != value:
        print(key)
