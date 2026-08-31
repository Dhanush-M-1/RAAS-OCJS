import os, sys
from io import IOBase, BytesIO
py2 = round(0.5)
if py2:
    from future_builtins import ascii, filter, hex, map, oct, zip
    range = xrange
BUFSIZE = 8192
class FastIO(BytesIO):
    newlines = 0
 
    def __init__(self, file):
        self._file = file
        self._fd = file.fileno()
        self.writable = 'x' in file.mode or 'w' in file.mode
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
            s = self._fill(); self.newlines = s.count(b'\n') + (not s)
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
 
# Cout implemented in Python
import sys
class ostream:
    def __lshift__(self,a):
        sys.stdout.write(str(a))
        return self
cout = ostream()
endl = '\n'

def get_input(a=str):
    return a(input())

def get_int_input():
    return get_input(int)

def get_input_arr(a):
    return list(map(a, input().split()))

def get_int_input_arr():
    return get_input_arr(int)





def solve():
    
    n, k = get_int_input_arr()

    books_both = []
    books_a = []
    books_b = []

    for _ in range(n):
        t_i, a_i, b_i = get_int_input_arr()

        if a_i == 1 and b_i == 1:
            books_both.append(t_i)

        elif a_i == 1 and b_i == 0:
            books_a.append(t_i)

        elif a_i == 0 and b_i == 1:
            books_b.append(t_i)

    books_both.sort()
    books_a.sort()
    books_b.sort()

    prefx_both = [0] * (len(books_both) + 1)
    for i in range(1, len(books_both) + 1):
        prefx_both[i] = prefx_both[i - 1] + books_both[i - 1]

    prefx_a = [0] * (len(books_a) + 1)
    for i in range(1, len(books_a) + 1):
        prefx_a[i] = prefx_a[i - 1] + books_a[i - 1]

    prefx_b = [0] * (len(books_b) + 1)
    for i in range(1, len(books_b) + 1):
        prefx_b[i] = prefx_b[i - 1] + books_b[i - 1]

    # print(books_both)

    def can_do(time):
        for i in range(min(k + 1, len(books_both) + 1)):
            # print(i)
            both_books_time = prefx_both[i]

            left_nums = k - i
            if  left_nums < 0 or left_nums >= len(prefx_a) or left_nums >= len(prefx_b):
                continue
            books_a_time = prefx_a[left_nums]
            books_b_time = prefx_b[left_nums]

            if time >= both_books_time + books_a_time + books_b_time:
                return True
        return False


    lo = 0
    hi = 10 ** 10

    res = float("inf")

    while lo <= hi:

        mid = lo + (hi - lo) // 2

        if can_do(mid):
            res = mid
            hi = mid - 1
        else:
            lo = mid + 1

    if res == float("inf"):
        cout<<-1<<endl
    else:
        cout<<res<<endl






def main():
    solve()


if __name__ == "__main__":
    main()