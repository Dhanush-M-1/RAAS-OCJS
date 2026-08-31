import sys
def rs(): return sys.stdin.readline().rstrip()
def ri(): return int(sys.stdin.readline())
def ria(): return list(map(int, sys.stdin.readline().split()))
def ws(s): sys.stdout.write(s); sys.stdout.write('\n')
def wi(n): sys.stdout.write(str(n)); sys.stdout.write('\n')
def wia(a, sep=' '): sys.stdout.write(sep.join([str(x) for x in a])); sys.stdout.write('\n')
 
 
def main():
    n, k = ria()
    a = ria()
    a = sorted(a, reverse=True)
    
    for i in range(n):
        if k % a[i] == 0:
            wi(k // a[i])
            return
 
 
if __name__ == '__main__':
    main()