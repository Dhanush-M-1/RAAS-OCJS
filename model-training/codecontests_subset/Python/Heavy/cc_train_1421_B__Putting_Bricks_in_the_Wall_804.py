from sys import stdin
input = stdin.readline
q = int(input())
for _ in range(q):
    n = int(input())
    mat = [list(input()) for i in range(n)]
    for i in range(n):
        mat[i] = mat[i][:n]
    l = [mat[0][1], mat[1][0]]
    r = [mat[-1][-2], mat[-2][-1]]
    if l[0] == l[1] and l[0] == '0':
        r[0] = '1'
        r[1] = '1'
    else:
        if l[0] == l[1] and l[0] == '1':
            r[0] = '0'
            r[1] = '0'
        else:
            if r[0]==r[1] and r[0] == '1':
                l[0] = '0'
                l[1] = '0'
            else:
                if r[0] == r[1] and r[0] == '0':
                    l[0] = '1'
                    l[1] = '1'
                else:
                    r[0] = '1'
                    r[1] = '1'
                    l[0] = '0'
                    l[1] = '0'
    cnt = 0
    zj = mat[0][1]
    jz = mat[1][0]
    bw = mat[-1][-2]
    wb = mat[-2][-1]
    #print(bw, mat[-1][-2])
    zmien = []
    if zj != l[0]:
        cnt += 1
        zmien.append([1,2])
    if jz != l[1]:
        cnt += 1
        zmien.append([2,1])
    if bw != r[0]:
        cnt += 1
        zmien.append([n,n-1])
    if wb != r[1]:
        cnt +=1
        zmien.append([n-1,n])
    print(cnt)
    for i in zmien:
        print(*i)