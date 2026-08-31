from sys import stdin, stdout
q=int(stdin.readline())
for i in range(q):
    [l,r,d]=[int(x) for x in stdin.readline().split()]
    cof=d
    while True:
        if (d>0 and d<l) or (d>r):
            stdout.write(str(d)+'\n')
            break
        else:
            stdout.write(str(d*((r//d)+1))+'\n')
            break
