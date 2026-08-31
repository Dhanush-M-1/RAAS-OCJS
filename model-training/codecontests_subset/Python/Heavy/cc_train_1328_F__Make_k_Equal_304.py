import collections, heapq, bisect, math
 
def gcd(a, b):
    if b == 0: return a
    return gcd(b, a%b)
 
def solve(A, K):
    mod = 1000000
    nodes = {0 : [set(), 0, []]}
 
    for a in A:
        count = 0
        last_val = mod
        while last_val != 0:
            if a not in nodes: nodes[a] = [{last_val}, 1, [-count]]
            else:        
                nodes[a][0].add(last_val)
                nodes[a][1] += 1
                if len(nodes[a][2]) == K: heapq.heappushpop(nodes[a][2], -count)
                else: heapq.heappush(nodes[a][2], -count) 
            count += 1
            last_val = a
            a //= 2
 
    for node in nodes: nodes[node][2] = -sum(nodes[node][2])
    best_node = 0
    states = {0}
    while states:
        new_states = set()
 
        for node in states:
            if node == mod: continue
            if nodes[node][1] >= K:
                new_states |= nodes[node][0]
                if nodes[node][2] < nodes[best_node][2]: best_node = node
        states = new_states
    return nodes[best_node][2]
    
 
 
n, k = input().split(' ')
tests = []
for test in range(1):
    #n = input()
    tests.append([int(p) for p in input().split(' ')])
for test in tests: print(solve(test,int(k)))
#print(solve(n,b))