'''

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

'''

# import numpy as np

parent = [0 for i in range(1001)]
rank = [0 for i in range(1001)]

def make_set(num):
    parent[num] = num
    rank[num] = 1
    
def find_set(a):
    if parent[a] == a:
        return a
    parent[a] = find_set(parent[a])
    return parent[a]
    
def union_sets(a, b):
    x = find_set(a)
    y = find_set(b)
    
    if x != y:
        if rank[x] < rank[y]:
            x, y = y, x
            
        parent[y] = x
        if rank[x] == rank[y]:
            rank[x] += 1
        
n = int(input())

for i in range(1, n+1):
    make_set(i)
    
to_remove = []    
for i in range(1, n):
    [a, b] = list(map(int, input().split()))
    # print (a, b)
    #b = int(input())
    if find_set(a) == find_set(b):
        to_remove.append((a, b))
    else:
        union_sets(a, b)
        
is_parent = [0 for i in range(1001)]
parents = []
for i in range(1, n+1):
    p = find_set(i)
    if is_parent[p] == 0:
        is_parent[p] = 1
        parents.append(p)
    
print(len(to_remove))
for i in range(len(to_remove)):
    print(to_remove[i][0], to_remove[i][1], parents[i], parents[i+1])