import sys
read=lambda:sys.stdin.readline().strip()
write=lambda x:sys.stdout.write(x+"\n")
pv=read().split();N=int(read())
write(' '.join(v for v in pv))
for _ in range(N):
    nv,rv=read().split()
    for i in range(2):
        if pv[i] == nv:
            pv[i] = rv
    write(' '.join(v for v in pv))