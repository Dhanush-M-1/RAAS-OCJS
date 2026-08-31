t = int(input())
for i in range(t):
    n = int(input())
    stats = []
    for j in range(n):
        stats += input().split()
    tries = int(stats[0])
    finished = int(stats[1])

    if finished > tries:
        print('NO')
        continue
    
    flag = True
    if n  <  2:
        if int(stats[0]) >= int(stats[1]):
            print('YES')
        else:
            print('NO')
        continue
        
    for k in range(2, len(stats), 2):
        if int(stats[k]) - tries < int(stats[k + 1]) - finished or int(stats[k + 1]) > int(stats[k]) or int(stats[k + 1]) < finished:
            print('NO')
            flag = False
            break
        else:
            tries = int(stats[k])
            finished = int(stats[k + 1])

    if flag:
        print('YES')
