class SegmentTree:
    def __init__(self,array,f=lambda x,y:x+y,inf=0):
        self.height = (len(array) - 1).bit_length()
        self.n = 2 ** (self.height)
        self.id = inf
        self.tree = [self.id] * (2 * self.n)
        self.f = f
        for i in range( len(array) ):
            self.tree[self.n+i] = array[i]
        for i in range (self.n - 1, 0, -1):
            self.tree[i] = self.f (self.tree[2*i], self.tree[2*i+1])
        
    def update(self, i, x):
        i += self.n
        self.tree[i] = x
        while i > 1:
            i //= 2
            self.tree[i] = self.f (self.tree[2*i], self.tree[2*i+1])
    
    def query(self,l,r):
        l += self.n
        r += self.n
        lf, rf = self.id, self.id
        while l < r:
            if l & 1:
                lf = self.f (lf, self.tree[l])
                l += 1
            if r & 1:
                r -= 1
                rf = self.f( self.tree[r], rf)
            l //= 2
            r //= 2
        return self.f (lf, rf)


    #FFFFTTTTとしたときの最小のTを求める(min-left)

    def BinarySearch(self, l, r, f):
        if not f (self.query(l, r)):
            return r + 1
        l += self.n
        r += self.n
        while True:
            if f (self.tree[l]):
                if l >= self.n:
                    return l - self.n + 1
                else:
                    l *= 2
            else:
                if l % 2 == 0:
                    l += 1
                else:
                    l = (l // 2) + 1

    def display(self):
        for i in range(self.n, self.n * 2):
            print(self.tree[i], end=" ")
            while i % 2 == 0:
                i //= 2
                print(self.tree[i], end=" ")
            print()


import sys
input=sys.stdin.readline

def solve(a, x):
    if len(a) == 0:
        return
    if len(a) == 1:
        ans[a[0] - 1] = x
        return
    m = max(a)
    ans[m - 1] = x
    for i in range(len(a)):
        if a[i] == m:
            solve(a[:i], x + 1)
            solve(a[i + 1:], x + 1)
t = int(input())
ansss = []
while t:
    t -= 1
    n = int(input())
    a = list(map(int, input().split()))
    ans = [0] * n
    solve(a, 0)
    anss = []
    for i in a:
        anss.append(ans[i - 1])
    ansss.append(anss)

for i in ansss:
    print(*i)