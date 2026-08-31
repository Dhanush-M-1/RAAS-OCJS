cases = int(input())
for c in range(cases):
    n = int(input())
    mat = []
    for i in range(n):
        row = input()
        mat.append(row)
    r0c1 = mat[0][1]
    r1c0 = mat[1][0]
    rncp = mat[n-1][n-2]
    rpcn = mat[n-2][n-1]

    if r0c1 == r1c0:
        changes = []
        if rncp == r0c1:
            changes.append(str(n-0) + " " + str(n-1))
        if rpcn == r0c1:
            changes.append(str(n-1) + " " + str(n-0))
        print(len(changes))
        for u in changes:
            print(u)
    elif rncp == rpcn:
        changes = []
        if rncp == r0c1:
            changes.append('1' + " " + '2')
        if rpcn == r1c0:
            changes.append('2' + " " + '1')
        print(len(changes))
        for u in changes:
            print(u)
    else:
        changes = []
        if r0c1 != '0':
            changes.append('1' + " " + '2')
        if r1c0 != '0':
            changes.append('2' + " " + '1')
        if rncp != '1':
            changes.append(str(n-0) + " " + str(n-1))
        if rpcn != '1':
            changes.append(str(n-1) + " " + str(n-0))
        print(len(changes))
        for u in changes:
            print(u)


