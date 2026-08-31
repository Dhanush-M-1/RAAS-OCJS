from sys import stdin, stdout

def find(node):
    x = []
    while dsu[node] > 0:
        x.append(node)
        node = dsu[node]
    for i in x:
        dsu[i] = node
    return node

def union(node1, node2):
    if dsu[node1] > dsu[node2]:
        node1, node2 = node2, node1
    dsu[node1] += dsu[node2]
    dsu[node2] = node1


n = int(stdin.readline().strip())
dsu = [-1]*(n+1)
remove = []
for __ in range(n-1):
    a, b = map(int, stdin.readline().strip().split())
    p_a, p_b = find(a), find(b)
    if p_a == p_b:
        remove.append((a,b))
    else:
        union(p_a, p_b)
req = []
for i in range(1, n+1):
    if dsu[i] < 0:
        req.append(i)
if len(req) == 1:
    stdout.write('0')
else:
    stdout.write(f'{len(req)-1}\n')
    pointer = 0
    for i in range(len(req)-1):
        stdout.write(f'{remove[pointer][0]} {remove[pointer][1]} {req[i]} {req[i+1]}\n')
        pointer += 1




