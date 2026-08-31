"""
    Author : thekushalghosh
    Team   : CodeDiggers
"""
import sys,math,cmath,time
start_time = time.time()
################# ---- USER DEFINED INPUT FUNCTIONS ---- #################
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(s[:len(s) - 1])
def invr():
    return(map(int,input().split()))
##########################################################################
################# ---- THE ACTUAL CODE STARTS BELOW ---- #################

def solve():
    n = inp()
    a = []
    for i in range(n):
        s = inlt()
        a.append(s)
    a.append(a[-1])
    qw = "YES"
    q = 0
    w = 0
    for i in range(len(a)):
        qq = a[i][0] - q
        ww = a[i][1] - w
        if a[i][0] < q or a[i][1] < w or a[i][0] < a[i][1] or ww > qq:
            qw = "NO"
            break
        q = a[i][0]
        w = a[i][1]
    print(qw)
            
    
################## ---- THE ACTUAL CODE ENDS ABOVE ---- ##################
##########################################################################
ONLINE_JUDGE = __debug__
if not ONLINE_JUDGE:
    sys.stdin = open('input.txt','r')
    sys.stdout = open('output.txt','w')
else:
    input = sys.stdin.readline
t = 1
t = inp()
for tt in range(t):
    solve()
if not ONLINE_JUDGE:
    print("Time Elapsed:",time.time() - start_time,"seconds")
sys.stdout.close()
