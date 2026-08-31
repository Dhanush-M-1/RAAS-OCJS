import sys
from collections import deque
input_ = lambda: sys.stdin.readline().strip("\r\n")
ii = lambda : int(input_())
il = lambda : list(map(int, input_().split()))
ilf = lambda : list(map(float, input_().split()))
ip = lambda : input_()
fi = lambda : float(input_())
li = lambda : list(input_())
pr = lambda x : print(x)
f = lambda : sys.stdout.flush()


def gen(x,l,r) :

    if (l == r) :
        return 
    ind = -1
    val = -1
    #print(l,r,a)
    for i in range(l,r) :
        #print(i,'a')
        if (val < a[i]) :
            ind = i
            val = a[i]

    gen(x+1,l,ind)
    gen(x+1,ind+1,r)
    #print(a,ind)
    a[ind] = x

for _ in range (ii()) :
    n = ii()
    a = il()
    gen(0,0,n)
    print(*a)


        

        
            
