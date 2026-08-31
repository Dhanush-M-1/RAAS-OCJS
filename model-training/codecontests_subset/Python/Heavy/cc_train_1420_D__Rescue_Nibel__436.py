#### IMPORTANT LIBRARY ####
 
############################
### DO NOT USE import random --> 250ms to load the library
############################
 
### In case of extra libraries: https://github.com/cheran-senthil/PyRival
 
######################
####### IMPORT #######
######################
 
from functools import cmp_to_key 
from collections import deque
from heapq import heappush, heappop
from math import log, ceil
 
######################
#### STANDARD I/O ####
######################
 
import sys
import os
from io import BytesIO, IOBase
 
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
 
if sys.version_info[0] < 3:
    sys.stdin, sys.stdout = FastIO(sys.stdin), FastIO(sys.stdout)
else:
    sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
 
def print(*args, **kwargs):
    sep, file = kwargs.pop("sep", " "), kwargs.pop("file", sys.stdout)
    at_start = True
    for x in args:
        if not at_start:
            file.write(sep)
        file.write(str(x))
        at_start = False
    file.write(kwargs.pop("end", "\n"))
    if kwargs.pop("flush", False):
        file.flush()
 
def inp():
    return sys.stdin.readline().rstrip("\r\n")  # for fast input
    
def ii():
    return int(inp())
 
def li(lag = 0):
    l = list(map(int, inp().split()))
    if lag != 0:
        for i in range(len(l)):
            l[i] += lag
    return l
    
def mi(lag = 0):
    matrix = list()
    for i in range(n):
        matrix.append(li(lag))
    return matrix
 
def sli(): #string list
    return list(map(str, inp().split()))
 
def print_list(lista, space = " "):
    print(space.join(map(str, lista)))
 
######################
##### UNION FIND #####
######################
 
class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.size = [1] * n
        self.num_sets = n
 
    def find(self, a):
        to_update = []
        while a != self.parent[a]:
            to_update.append(a)
            a = self.parent[a]
        for b in to_update:
            self.parent[b] = a
        return self.parent[a]
 
    def merge(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return
        if self.size[a] < self.size[b]:
            a, b = b, a
        self.num_sets -= 1
        self.parent[b] = a
        self.size[a] += self.size[b]
 
    def set_size(self, a):
        return self.size[self.find(a)]
 
    def __len__(self):
        return self.num_sets
 
######################
### BISECT METHODS ###
######################
 
def bisect_left(a, x):
    """i tale che a[i] >= x e a[i-1] < x"""
    left = 0
    right = len(a)
    while left < right:
        mid = (left+right)//2
        if a[mid] < x: 
            left = mid+1
        else: 
            right = mid
    return left
 
def bisect_right(a, x):
    """i tale che a[i] > x e a[i-1] <= x"""
    left = 0
    right = len(a)
    while left < right:
        mid = (left+right)//2
        if a[mid] > x: 
            right = mid
        else: 
            left = mid+1
    return left
 
def bisect_elements(a, x):
    """elementi pari a x nell'árray sortato"""
    return bisect_right(a, x) - bisect_left(a, x)
 
######################
#### CUSTOM SORT #####
######################
 
def custom_sort(lista):
    def cmp(x,y): 
        if x+y>y+x:
            return 1 
        else:
            return -1
    return sorted(lista, key = cmp_to_key(cmp))
 
######################
### MOD OPERATION ####
######################
 
#MOD = 10**9 + 7
MOD = 998244353
maxN = 3*10**5+7
FACT = [0] * maxN
 
def add(x, y):
    return (x+y) % MOD
   
def multiply(x, y):
    return (x*y) % MOD
 
def power(x, y):
    if y == 0:
        return 1
    elif y % 2:
        return multiply(x, power(x, y-1))
    else:
        a = power(x, y//2)
        return multiply(a, a)
 
def inverse(x):
    return power(x, MOD-2)
   
def divide(x, y):
    return multiply(x, inverse(y))
 
def allFactorials():
    FACT[0] = 1
    for i in range(1, maxN):
        FACT[i] = multiply(i, FACT[i-1])
 
def coeffBinom(n, k):
    if n < k:
        return 0
    return divide(FACT[n], multiply(FACT[k], FACT[n-k]))
 
 
 
######################
#### GCD & PRIMES ####
######################
 
def primes(N):
    smallest_prime = [1] * (N+1)
    prime = [] 
    smallest_prime[0] = 0
    smallest_prime[1] = 0
    for i in range(2, N+1):  
        if smallest_prime[i] == 1: 
            prime.append(i)
            smallest_prime[i] = i
        j = 0
        while (j < len(prime) and i * prime[j] <= N): 
            smallest_prime[i * prime[j]] = min(prime[j], smallest_prime[i])
            j += 1
    return prime, smallest_prime
 
def gcd(a, b):
    a = abs(a)
    b = abs(b)
    s, t, r = 0, 1, b
    old_s, old_t, old_r = 1, 0, a
    while r != 0:
        quotient = old_r//r
        old_r, r = r, old_r - quotient*r
        old_s, s = s, old_s - quotient*s
        old_t, t = t, old_t - quotient*t
    return old_r, old_s, old_t #gcd, x, y for ax+by=gcd
 
######################
#### GRAPH ALGOS #####
######################
 
# ZERO BASED GRAPH
def create_graph(n, m, undirected = 1, unweighted = 1):
    graph = [[] for i in range(n)]
    if unweighted:
        for i in range(m):
            [x, y] = li(lag = -1)
            graph[x].append(y)
            if undirected:
                graph[y].append(x)
    else:
        for i in range(m):
            [x, y, w] = li(lag = -1)
            w += 1
            graph[x].append([y,w])
            if undirected:
                graph[y].append([x,w])
    return graph
 
def create_tree(n, unweighted = 1):
    children = [[] for i in range(n)]
    if unweighted:
        for i in range(n-1):
            [x, y] = li(lag = -1)
            children[x].append(y)
            children[y].append(x)
    else:
        for i in range(n-1):
            [x, y, w] = li(lag = -1)
            w += 1
            children[x].append([y, w])
            children[y].append([x, w])
    return children
   
def create_edges(m, unweighted = 0):
    edges = list()
    if unweighted:
        for i in range(m):
            edges.append(li(lag = -1))
    else:
        for i in range(m):
            [x, y, w] = li(lag = -1)
            w += 1
            edges.append([w,x,y])
    return edges
 
def dist(tree, n, A, B = -1):
    s = [[A, 0]]
    massimo, massimo_nodo = 0, 0
    distanza = -1
    v = [-1] * n
    while s:
        el, dis = s.pop() 
        if dis > massimo:
            massimo = dis
            massimo_nodo = el
        if el == B:
            distanza = dis
        for child in tree[el]:
            if v[child] == -1:
                v[child] = 1
                s.append([child, dis+1])
    return massimo, massimo_nodo, distanza
 
def diameter(tree):
    _, foglia, _ = dist(tree, n, 0)
    diam, _, _ = dist(tree, n, foglia)
    return diam
   
def dfs(graph, n, A):
    v = [-1] * n
    s = [[A, 0]]
    v[A] = 0
    while s:
        el, dis = s.pop()
        for child in graph[el]:
            if v[child] == -1:
                v[child] = dis + 1
                s.append([child, dis + 1])
    return v #visited: -1 if not visited, otherwise v[B] is the distance in terms of edges
 
def bfs(graph, n, A):
    v = [-1] * n
    s = deque()
    s.append([A, 0])
    v[A] = 0
    while s:
        el, dis = s.popleft()
        for child in graph[el]:
            if v[child] == -1:
                v[child] = dis + 1
                s.append([child, dis + 1])
    return v #visited: -1 if not visited, otherwise v[B] is the distance in terms of edges
 
def connected(graph, n):
    v = dfs(graph, n, 0)
    for el in v:
        if el == -1:
            return False
    return True
 
# NON DIMENTICARTI DI PRENDERE GRAPH COME DIRETTO
def topological(graph, n):
    indegree = [0] * n
    for el in range(n):
        for child in graph[el]:
            indegree[child] += 1
    s = deque()
    for el in range(n):
        if indegree[el] == 0:
            s.append(el)
    order = []
    while s:
        el = s.popleft()
        order.append(el)
        for child in graph[el]:
            indegree[child] -= 1
            if indegree[child] == 0:
                s.append(child)
    if n == len(order):
        return False, order #False == no cycle
    else:
        return True, [] #True == there is a cycle and order is useless
 
# ASSUMING CONNECTED
def bipartite(graph, n):
    color = [-1] * n
    color[0] = 0
    s = [0]
    while s:
        el = s.pop()
        for child in graph[el]:
            if color[child] == color[el]:
                return False
            if color[child] == -1:
                s.append(child)
            color[child] = 1 - color[el]
    return True
 
# SHOULD BE DIRECTED AND WEIGHTED
def dijkstra(graph, n, A):
    dist = [float('inf') for i in range(n)]
    prev = [-1 for i in range(n)]
    dist[A] = 0
    pq = []
    heappush(pq, [0, A])
    while pq:
        [d_v, v] = heappop(pq)
        if (d_v != dist[v]):
            continue
        for to, w in graph[v]:
            if dist[v] + w < dist[to]:
                dist[to] = dist[v] + w
                prev[to] = v
                heappush(pq, [dist[to], to])
    return dist, prev
 
# SHOULD BE DIRECTED AND WEIGHTED
def dijkstra_0_1(graph, n, A):
    dist = [float('inf') for i in range(n)]
    dist[A] = 0
    p = deque()
    p.append(A)
    while p:
        v = p.popleft()
        for to, w in graph[v]:
            if dist[v] + w < dist[to]:
                dist[to] = dist[v] + w
            if w == 1:
                q.append(to)
            else:
                q.appendleft(to)
    return dist
 
#SHOULD BE WEIGHTED (AND UNDIRECTED)
def floyd_warshall(graph, n):
    dist = [[float('inf') for _ in range(n)] for _ in range(n)]
    for i in range(n):
        dist[i][i] = 0
        for child, d in graph[i]:
            dist[i][child] = d
            dist[child][i] = d
    for k in range(n):
        for i in range(n):
            for j in range(j):
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
    return dist
 
#EDGES [w,x,y]
def minimum_spanning_tree(edges, n):
    edges = sorted(edges)
    union_find = UnionFind(n) #implemented above
    used_edges = list()
    for w, x, y in edges:
        if union_find.find(x) != union_find.find(y):
            union_find.merge(x, y)
            used_edges.append([w,x,y])
    return used_edges
 
#FROM A GIVEN ROOT, RECOVER THE STRUCTURE
def parents_children_root_unrooted_tree(tree, n, root = 0):
    q = deque()
    visited = [0] * n
    parent = [-1] * n
    children = [[] for i in range(n)]
    q.append(root)
    while q:
        all_done = 1
        visited[q[0]] = 1
        for child in tree[q[0]]:
            if not visited[child]:
                all_done = 0
                q.appendleft(child)
        if all_done:
            for child in tree[q[0]]:   
                if parent[child] == -1:
                    parent[q[0]] = child
                    children[child].append(q[0])
            q.popleft()
    return parent, children
 
# CALCULATING LONGEST PATH FOR ALL THE NODES 
def all_longest_path_passing_from_node(parent, children, n):
    q = deque()
    visited = [len(children[i]) for i in range(n)]
    downwards = [[0,0] for i in range(n)]
    upward = [1] * n
    longest_path = [1] * n
    for i in range(n):
        if not visited[i]:
            q.append(i)
            downwards[i] = [1,0]
    while q:
        node = q.popleft()
        if parent[node] != -1:
            visited[parent[node]] -= 1
            if not visited[parent[node]]:
                q.append(parent[node])
        else:
            root = node
        for child in children[node]:   
            downwards[node] = sorted([downwards[node][0], downwards[node][1], downwards[child][0] + 1], reverse = True)[0:2]
    s = [node]
    while s:
        node = s.pop()
        if parent[node] != -1:
            if downwards[parent[node]][0] == downwards[node][0] + 1:
                upward[node] = 1 + max(upward[parent[node]], downwards[parent[node]][1])
            else:
                upward[node] = 1 + max(upward[parent[node]], downwards[parent[node]][0])
        longest_path[node] = downwards[node][0] + downwards[node][1] + upward[node] - min([downwards[node][0], downwards[node][1], upward[node]]) - 1
        for child in children[node]:
            s.append(child)
    return longest_path
 
def finding_ancestors(parent, queries, n):
    steps = int(ceil(log(n, 2)))
    ancestors = [[-1 for i in range(n)] for j in range(steps)]
    ancestors[0] = parent
    for i in range(1, steps):
        for node in range(n):
            if ancestors[i-1][node] != -1:
                ancestors[i][node] = ancestors[i-1][ancestors[i-1][node]]
    result = []
    for node, k in queries:
        ans = node
        if k >= n:
            ans = -1
        i = 0
        while k > 0 and ans != -1:
            if k % 2:
                ans = ancestors[i][ans]
            k = k // 2
            i += 1
        result.append(ans)
    return result #Preprocessing in O(n log n). For each query O(log k)
 
### TBD SUCCESSOR GRAPH 7.5
### TBD TREE QUERIES 10.2 da 2 a 4
### TBD ADVANCED TREE 10.3
### TBD GRAPHS AND MATRICES 11.3.3 e 11.4.3 e 11.5.3 (ON GAMES)
 
######################
####### OTHERS #######
######################
 
def prefix_sum(arr):
    r = [0] * (len(arr)+1)
    for i, el in enumerate(arr):
        r[i+1] = r[i] + el
    return r
   
def nearest_from_the_left_smaller_elements(arr):
    n = len(arr)
    res = [-1] * n
    s = []
    for i, el in enumerate(arr):
        while s and s[-1] >= el:
            s.pop()
        if s:
            res[i] = s[-1]
        s.append(el)
    return res
 
def sliding_window_minimum(arr, k):
    res = []
    q = deque()
    for i, el in enumerate(arr):
        while q and arr[q[-1]] >= el:
            q.pop()
        q.append(i)
        while q and q[0] <= i - k:
            q.popleft()
        if i >= k-1:
            res.append(arr[q[0]])
    return res
 
### TBD COUNT ELEMENT SMALLER THAN SELF
 
######################
## END OF LIBRARIES ##
######################
 
allFactorials()
 
n, k = li()
ev = []
for i in range(n):
    a = li()
    ev.append(2*a[0])
    ev.append(2*a[1]+1)
ev.sort()
c = 0
s = 0
for  ap in ev:
    if ap % 2 == 0:
        c+=1
        s = add(s, coeffBinom(c-1, k-1))
    else:
        c-=1
print(s)