# fin = open("a.in", "r")
# buf = fin.read()
# fin.close()
import sys
buf = sys.stdin.read()
nowbuf = 0
endbuf = len(buf)

def getint():
    global nowbuf
    valnow = 0
    while buf[nowbuf] < '0' or buf[nowbuf] > '9':
        nowbuf += 1
    while nowbuf < endbuf and buf[nowbuf] >= '0' and buf[nowbuf] <= '9':
        valnow = valnow * 10 + int(buf[nowbuf])
        nowbuf += 1
    return valnow

def solve(n):
    a = []
    for i in range(0, n):
        a.append(getint())
    if a[0] + a[1] <= a[n - 1]:
        print("1 2", n)
    else:
        print("-1")
    return

t = getint()
for i in range(0, t):
    solve(getint())