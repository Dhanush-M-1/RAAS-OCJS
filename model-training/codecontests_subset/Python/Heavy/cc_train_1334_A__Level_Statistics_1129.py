t = int(input())
out = list()

for item in range(t):

    n = int(input())

    old = [0,0]
    OK = 0

    for item in range(n):
        pc_list = input().split()
        p = int(pc_list[0])
        c = int(pc_list[1])

        if p < c:
            OK = 0
            #break
        elif p - old[0] < 0 or c - old[1] < 0:
            OK = 0
            #break
        elif p - old[0] < c - old[1]:
            OK = 0
            #break
        else: OK += 1

        old = [p,c]

    if OK == n: out.append('YES')
    else: out.append('NO')
    #print(OK)

for item in out: print(item)
