from sys import stdin

a=int(stdin.readline())

for b in range(0,a):
    c=int(stdin.readline())
    d=stdin.readline().split()
    C=int(d[0])
    D=int(d[1])
    

    if c==1:
        if C>=D:
            print('YES')
            continue
        else:
            print('NO')
            continue
    K=0
    for e in range(1,c):
        d=stdin.readline().split()
        A=C
        B=D
        C=int(d[0])
        D=int(d[1])
        if (C>=A and D>=B) and (C>=D and (C-A>=D-B and A>=B)):
            continue
        else:
            print('NO')
            for g in range(e+1,c):
                stdin.readline()
            K=1
            break
    if K==0:
        print('YES')