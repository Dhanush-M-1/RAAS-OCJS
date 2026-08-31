#from bisect import bisect_left as bl                #c++ lowerbound bl(array,element)
#from bisect import bisect_right as br               #c++ upperbound br(array,element)
#from __future__ import print_function, division    #while using python2


def modinv(n,p):
    return pow(n,p-2,p)

def main():
    #sys.stdin = open('input.txt', 'r')
    #sys.stdout = open('output.txt', 'w')

    n, k = [int(x) for x in input().split()]
    alice = []
    bob = []
    both = []
    for i in range(n):
        t, a, b = [int(x) for x in input().split()]
        if a == 1 and b == 1:
            both.append(t/2)
        elif a == 1:
            alice.append(t)
        elif b == 1:
            bob.append(t)
        else:
            pass

    alice.sort()
    bob.sort()
    both.sort()
    
    k_alice = k
    k_bob = k 
    final_t = 0

    i = 0
    j = 0
    k = 0

    p = len(alice)
    q = len(bob)
    r = len(both)
    for i in range(k + 1):
        alice.append(99999)
        bob.append(99999)
        both.append(99999)
    t = 0
    break_flag = False

    # print(alice)
    # print(bob)
    # print(both)

    t = 0
    impossible = False
    while k_alice > 0 and k_bob > 0:
        if 2 * both[k] <= alice[i] + bob[j]:
            inc = int(2 * both[k])
            if inc >= 99999:
                impossible = True
                print(-1)
                return
            t += inc
            k += 1
        else:
            inc = 0
            inc += alice[i]
            inc += bob[j]
            if inc >= 99999:
                impossible = True
                print(-1)
                return
            t += inc
            i += 1
            j += 1
        k_bob -= 1
        k_alice -= 1
    
    while k_alice > 0:
        if alice[i] <= int(2*both[j]):
            inc = alice[i]
            if inc >= 99999:
                impossible = True
                print(-1)
                return
            t += inc 
            i += 1
        else:
            inc = int(both[k] * 2)
            if inc >= 99999:
                impossible = True
                print(-1)
                return
            t += inc
            k += 1
        k_alice -= 1
    
    while k_bob > 0:
        if bob[j] <= int(2*both[k]):
            inc = bob[j]
            if inc >= 99999:
                impossible = True
                print(-1)
                return
            t += inc
            j += 1
        else:
            inc = int(both[k] * 2)
            if inc >= 99999:
                impossible = True
                print(-1)
                return
            t += inc
            k += 1
        k_bob -= 1
    if impossible:
        print(-1)
    else:
        print(t)

#------------------ Python 2 and 3 footer by Pajenegod and c1729-----------------------------------------
py2 = round(0.5)
if py2:
    from future_builtins import ascii, filter, hex, map, oct, zip
    range = xrange

import os, sys
from io import IOBase, BytesIO

BUFSIZE = 8192
class FastIO(BytesIO):
    newlines = 0
    def __init__(self, file):
        self._file = file
        self._fd = file.fileno()
        self.writable = "x" in file.mode or "w" in file.mode
        self.write = super(FastIO, self).write if self.writable else None

    def _fill(self):
        s = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
        self.seek((self.tell(), self.seek(0,2), super(FastIO, self).write(s))[0])
        return s
    def read(self):
        while self._fill(): pass
        return super(FastIO,self).read()

    def readline(self):
        while self.newlines == 0:
            s = self._fill(); self.newlines = s.count(b"\n") + (not s)
        self.newlines -= 1
        return super(FastIO, self).readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.getvalue())
            self.truncate(0), self.seek(0)

class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        if py2:
            self.write = self.buffer.write
            self.read = self.buffer.read
            self.readline = self.buffer.readline
        else:
            self.write = lambda s:self.buffer.write(s.encode('ascii'))
            self.read = lambda:self.buffer.read().decode('ascii')
            self.readline = lambda:self.buffer.readline().decode('ascii')

sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip('\r\n')

if __name__ == '__main__':
   main()
