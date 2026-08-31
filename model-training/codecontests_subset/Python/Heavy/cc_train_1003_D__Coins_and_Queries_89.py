from sys import stdin, stdout

get_string = lambda: stdin.readline().strip('\n')
get_intmap = lambda: map( int, get_string().split(' ') )
#get_intmap

def ncr_generator(n,r):
    ncrr = 1
    while True:
        yield ncrr
        n   += 1
        ncrr = ( ncrr * n // (n - r) ) 

from collections import Counter
def testcase():
    n,q = get_intmap()
    a   = tuple(get_intmap())
    cnt  = Counter(a)
    keys = sorted(cnt.keys(),reverse = True)
    blist = [int(get_string()) for i in range(q)]
    ans   = ['-1'] * q
    for ind in range(q):
        #b = int(get_string())
        b, tmp = blist[ind], 0
        for key in keys:
            q,r = divmod(b,key)
            m   = min(q, cnt[key])
            tmp += m
            b   -= m * key
            if b == 0:
                ans[ind] = str(tmp)
                break
    print("\n".join(ans))

    

        

testcase()
#for t in range(int(input())):
#    testcase()
