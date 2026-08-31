# ---------------------------iye ha aam zindegi---------------------------------------------
import math
import heapq, bisect
import sys
from collections import deque, defaultdict
from fractions import Fraction
import sys
mod = 10 ** 9 + 7
mod1 = 998244353
#setrecursionlimit(300000)
# ------------------------------warmup----------------------------
import os
import sys
from io import BytesIO, IOBase
BUFSIZE = 8192
sys.setrecursionlimit(300000)
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


# -------------------game starts now----------------------------------------------------import math
class SegmentTree:
    def __init__(self, data, default=0, func=lambda a, b: a + b):
        """initialize the segment tree with data"""
        self._default = default
        self._func = func
        self._len = len(data)
        self._size = _size = 1 << (self._len - 1).bit_length()

        self.data = [default] * (2 * _size)
        self.data[_size:_size + self._len] = data
        for i in reversed(range(_size)):
            self.data[i] = func(self.data[i + i], self.data[i + i + 1])

    def __delitem__(self, idx):
        self[idx] = self._default

    def __getitem__(self, idx):
        return self.data[idx + self._size]

    def __setitem__(self, idx, value):
        idx += self._size
        self.data[idx] = value
        idx >>= 1
        while idx:
            self.data[idx] = self._func(self.data[2 * idx], self.data[2 * idx + 1])
            idx >>= 1

    def __len__(self):
        return self._len

    def query(self, start, stop):
        if start == stop:
            return self.__getitem__(start)
        stop += 1
        start += self._size
        stop += self._size

        res = self._default
        while start < stop:
            if start & 1:
                res = self._func(res, self.data[start])
                start += 1
            if stop & 1:
                stop -= 1
                res = self._func(res, self.data[stop])
            start >>= 1
            stop >>= 1
        return res

    def __repr__(self):
        return "SegmentTree({0})".format(self.data)


# -------------------------------iye ha chutiya zindegi-------------------------------------
class Factorial:
    def __init__(self, MOD):
        self.MOD = MOD
        self.factorials = [1, 1]
        self.invModulos = [0, 1]
        self.invFactorial_ = [1, 1]

    def calc(self, n):
        if n <= -1:
            print("Invalid argument to calculate n!")
            print("n must be non-negative value. But the argument was " + str(n))
            exit()
        if n < len(self.factorials):
            return self.factorials[n]
        nextArr = [0] * (n + 1 - len(self.factorials))
        initialI = len(self.factorials)
        prev = self.factorials[-1]
        m = self.MOD
        for i in range(initialI, n + 1):
            prev = nextArr[i - initialI] = prev * i % m
        self.factorials += nextArr
        return self.factorials[n]

    def inv(self, n):
        if n <= -1:
            print("Invalid argument to calculate n^(-1)")
            print("n must be non-negative value. But the argument was " + str(n))
            exit()
        p = self.MOD
        pi = n % p
        if pi < len(self.invModulos):
            return self.invModulos[pi]
        nextArr = [0] * (n + 1 - len(self.invModulos))
        initialI = len(self.invModulos)
        for i in range(initialI, min(p, n + 1)):
            next = -self.invModulos[p % i] * (p // i) % p
            self.invModulos.append(next)
        return self.invModulos[pi]

    def invFactorial(self, n):
        if n <= -1:
            print("Invalid argument to calculate (n^(-1))!")
            print("n must be non-negative value. But the argument was " + str(n))
            exit()
        if n < len(self.invFactorial_):
            return self.invFactorial_[n]
        self.inv(n)  # To make sure already calculated n^-1
        nextArr = [0] * (n + 1 - len(self.invFactorial_))
        initialI = len(self.invFactorial_)
        prev = self.invFactorial_[-1]
        p = self.MOD
        for i in range(initialI, n + 1):
            prev = nextArr[i - initialI] = (prev * self.invModulos[i % p]) % p
        self.invFactorial_ += nextArr
        return self.invFactorial_[n]


class Combination:
    def __init__(self, MOD):
        self.MOD = MOD
        self.factorial = Factorial(MOD)

    def ncr(self, n, k):
        if k < 0 or n < k:
            return 0
        k = min(k, n - k)
        f = self.factorial
        return f.calc(n) * f.invFactorial(max(n - k, k)) * f.invFactorial(min(k, n - k)) % self.MOD


# --------------------------------------iye ha combinations ka zindegi---------------------------------
def powm(a, n, m):
    if a == 1 or n == 0:
        return 1
    if n % 2 == 0:
        s = powm(a, n // 2, m)
        return s * s % m
    else:
        return a * powm(a, n - 1, m) % m


# --------------------------------------iye ha power ka zindegi---------------------------------
def sort_list(list1, list2):
    zipped_pairs = zip(list2, list1)

    z = [x for _, x in sorted(zipped_pairs)]

    return z


# --------------------------------------------------product----------------------------------------
def product(l):
    por = 1
    for i in range(len(l)):
        por *= l[i]
    return por


# --------------------------------------------------binary----------------------------------------
def binarySearchCount(arr, n, key):
    left = 0
    right = n - 1

    count = 0

    while (left <= right):
        mid = int((right + left) / 2)

        # Check if middle element is
        # less than or equal to key
        if (arr[mid] < key):
            count = mid + 1
            left = mid + 1

        # If key is smaller, ignore right half
        else:
            right = mid - 1

    return count


# --------------------------------------------------binary----------------------------------------
def countdig(n):
    c = 0
    while (n > 0):
        n //= 10
        c += 1
    return c
def binary(x, length):
    y = bin(x)[2:]
    return y if len(y) >= length else "0" * (length - len(y)) + y

def countGreater(arr, n, k):
    l = 0
    r = n - 1

    # Stores the index of the left most element
    # from the array which is greater than k
    leftGreater = n

    # Finds number of elements greater than k
    while (l <= r):
        m = int(l + (r - l) / 2)
        if (arr[m] >= k):
            leftGreater = m
            r = m - 1

        # If mid element is less than
        # or equal to k update l
        else:
            l = m + 1

    # Return the count of elements
    # greater than k
    return (n - leftGreater)


# --------------------------------------------------binary------------------------------------
class BinaryTrie:
    class Node:
        def __init__(self, bit: bool = False):
            self.bit = bit  # Stores the current bit (False if 0, True if 1)
            self.children = []
            self.count = 0  # stores number of keys finishing at this bit
            self.counter = 1  # stores number of keys with this bit as prefix

    def __init__(self, size):
        self.root = BinaryTrie.Node()
        self.size = size  # Maximum size of each key

    def convert(self, key):
        """Converts key from string/integer to a list of boolean values!"""
        bits = []
        if isinstance(key, int):
            key = bin(key)[2:]
        if isinstance(key, str):
            for i in range(self.size - len(key)):
                bits += [False]
            for i in key:
                if i == "0":
                    bits += [False]
                else:
                    bits += [True]
        else:
            return list(key)
        return bits

    def add(self, key):
        """Add a key to the trie!"""
        node = self.root
        bits = self.convert(key)
        for bit in bits:
            found_in_child = False
            for child in node.children:
                if child.bit == bit:
                    child.counter += 1
                    node = child
                    found_in_child = True
                    break
            if not found_in_child:
                new_node = BinaryTrie.Node(bit)
                node.children.append(new_node)
                node = new_node
        node.count += 1

    def remove(self, key):
        """Removes a key from the trie! If there are multiple occurences, it removes only one of them."""
        node = self.root
        bits = self.convert(key)
        nodelist = [node]
        for bit in bits:
            for child in node.children:
                if child.bit == bit:
                    node = child
                    node.counter -= 1
                    nodelist.append(node)
                    break
        node.count -= 1
        if not node.children and not node.count:
            for i in range(len(nodelist) - 2, -1, -1):
                nodelist[i].children.remove(nodelist[i + 1])
                if nodelist[i].children or nodelist[i].count:
                    break

    def query(self, prefix, root=None):
        """Search for a prefix in the trie! Returns the node if found, otherwise 0."""
        if not root: root = self.root
        node = root
        if not root.children:
            return 0
        for bit in prefix:
            bit_not_found = True
            for child in node.children:
                if child.bit == bit:
                    bit_not_found = False
                    node = child
                    break
            if bit_not_found:
                return 0
        return node
#--------------------------------------------trie-------------------------------------------------
class TrieNode:

    # Trie node class
    def __init__(self):
        self.children = [None] * 26
        self.data=0
        self.isEndOfWord = False


class Trie:

    # Trie data structure class
    def __init__(self):
        self.root = self.getNode()

    def getNode(self):

        # Returns new trie node (initialized to NULLs)
        return TrieNode()

    def _charToIndex(self, ch):

        # private helper function
        # Converts key current character into index
        # use only 'a' through 'z' and lower case

        return ord(ch) - ord('a')

    def insert(self, key,val):
        pCrawl = self.root
        length = len(key)
        for level in range(length):
            index = self._charToIndex(key[level])

            # if current character is not present
            if not pCrawl.children[index]:
                pCrawl.children[index] = self.getNode()
            pCrawl = pCrawl.children[index]
            pCrawl.data+=val
        pCrawl.isEndOfWord = True

    def search(self, key):

        # Search key in the trie
        # Returns true if key presents
        # in trie, else false
        pCrawl = self.root
        length = len(key)
        c=0
        for level in range(length):
            index = self._charToIndex(key[level])
            if not pCrawl.children[index]:
                return False
            pCrawl = pCrawl.children[index]
        return pCrawl!=None
    def present(self, key):
        ans=0
        pCrawl = self.root
        length = len(key)
        c=0
        for level in range(length):
            index = self._charToIndex(key[level])
            if not pCrawl.children[index]:
                return False
            pCrawl = pCrawl.children[index]
            ans+=pCrawl.data
        if pCrawl!=None:
            return ans
        return -1
#----------------------------------trie----------------------------
for ik in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    l.sort()
    f=0
    for i in range(2,n):
        if l[i-1]+l[i-2]<=l[-1]:
            print(i-1,i,n)
            f=1
            break
    if f==0:
        print(-1)