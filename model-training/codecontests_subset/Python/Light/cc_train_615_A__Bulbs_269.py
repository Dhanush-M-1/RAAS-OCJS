n,m = map(int,input().split(' '))
all_working_bulbs = []
for swtch in range(n):
    inst = list(map(int,input().split(' ')))
    for i in range(1,inst[0]+1):
        all_working_bulbs.append(inst[i])
    
all_bulbs = list(set(all_working_bulbs))
if len(all_bulbs) == m:
    print('YES')
else:
    print('NO')