#   author : prottoyfuad
#   30.09.2020 04:17:01(+0600)

import sys, math, time
start_time = time.time()

def read() :
    return( int(input()) )
def read_args() :
    return( map(int, input().split()) )
def read_array() :
    return( list( map(int, input().split()) ) )
def read_string() :
    return( input().strip() )

def hocus_pocus() :
    n = read()
    a = [0] * n
    h = [0] * n
    for i in range(n) :
        a[i], h[i] = read_args()
    ans = min(n, 2)
    for i in range(1, n - 1) :
        if a[i] - h[i] > a[i - 1] :
            ans += 1
        elif a[i] + h[i] < a[i + 1] :
            ans += 1
            a[i] += h[i]
    print(ans)

if __debug__ :
    input = sys.stdin.readline
else :
    sys.stdin = open("D:\pro_code\py\in.txt","r");
    sys.stdout = open("D:\pro_code\py\out.txt","w");
global tc
tt = 1
# tt = read()
for tc in range(tt) :
    hocus_pocus()
if not __debug__ :
    print("Time elapsed :", time.time() - start_time, "seconds")
    sys.stdout.close()
