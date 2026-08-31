import os
import sys
from io import BytesIO, IOBase
from collections import defaultdict as dd
# from collections import deque as dq
# import itertools as it
# from math import sqrt, log, log2
# from fractions import Fraction

def main():
    n, k = map(int, input().split())
    alike, blike = 0, 0
    zero_one, one_zero, one_one, zero_zero = [], [], [], []
    for i in range(n):
        t, a, b = map(int, input().split())
        alike += a
        blike += b

        if a == 0 and b == 1:
            zero_one.append((t, i))
        elif a == 1 and b == 0:
            one_zero.append((t, i))
        elif a== 1 and b== 1:
            one_one.append((t, i))
        else:
            pass
            # zero_zero.append((t, i))


    if alike < k or blike < k:
        print(-1)
        exit()

    zero_one.sort(key = lambda x: x[0])
    one_one.sort(key = lambda x: x[0])
    one_zero.sort(key = lambda x: x[0])
    # zero_zero.sort(key = lambda x: x[0])

    alike, blike = 0, 0
    zo, oo, oz, zz = 0, 0, 0, 0
    lzo, loo, loz = len(zero_one), len(one_one), len(one_zero)
    # lzo, loo, loz, lzz = len(zero_one), len(one_one), len(one_zero), len(zero_zero)
    tottime = 0
    # books = []

    while alike<k or blike<k:
        # if oo >= loo and zo >= lzo and oz>=loz:
        #     break
        # lbo = len(books)
        # if lbo == m:
        if alike <k and blike <k:
            if oo>= loo and zo>=lzo and oz>=loz:
                print(-1)
                exit()
            
            elif zo >= lzo or oz >= loz:
                tottime += one_one[oo][0]
                # books.append(one_one[oo][1])
                oo += 1

            elif oo >= loo:
                tottime += zero_one[zo][0] + one_zero[oz][0]
                # books.append(zero_one[zo][1])
                # books.append(zero_one[oz][1])
                zo += 1
                oz += 1

            elif zero_one[zo][0] + one_zero[oz][0] < one_one[oo][0]:
                tottime += zero_one[zo][0] + one_zero[oz][0]
                # books.append(zero_one[zo][1])
                # books.append(zero_one[oz][1])
                zo += 1
                oz += 1
                
            else:
                tottime += one_one[oo][0]
                # books.append(one_one[oo][1])
                oo += 1

            alike += 1
            blike += 1

        elif alike == k and blike < k:
            if oo>=loo and zo>=lzo:
                print(-1)
                exit()
            elif oo >= loo:
                tottime += zero_one[zo][0]
                # books.append(zero_one[zo][1])
                zo += 1
            elif zo >= lzo:
                tottime += one_one[oo][0]
                # books.append(one_one[oo][1])
                oo += 1
            elif zero_one[zo][0] < one_one[oo][0]:
                tottime += zero_one[zo][0]
                # books.append(zero_one[zo][1])
                zo += 1
            else:
                tottime += one_one[oo][0]
                # books.append(one_one[oo][1])
                oo += 1

            blike += 1
        
        elif alike <k and blike == k:
            if oo>=loo and oz>=loz:
                print(-1)
                exit()
            elif oo>=loo:
                tottime += one_zero[oz][0]
                # books.append(one_zero[oz][1])
                oz += 1
            elif oz>= loz:
                tottime += one_one[oo][0]
                # books.append(one_one[oo][1])
                oo += 1
            elif one_zero[oz][0] < one_one[oo][0]:
                tottime += one_zero[oz][0]
                # books.append(one_zero[oz][1])
                oz += 1
            else:
                tottime += one_one[oo][0]
                # books.append(one_one[oo][1])
                oo += 1
        
    print(tottime)
    # print(*books)
































# region fastio
BUFSIZE = 8192
class FastIO(IOBase):
    newlines = 0
    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None
 
    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()
 
    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()
 
    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)

class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")
sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")
# endregion
 
if __name__ == "__main__":
    main()