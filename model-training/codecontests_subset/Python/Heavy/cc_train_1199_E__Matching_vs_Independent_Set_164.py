from sys import stdin
input = stdin.readline
 
T = int(input())
 
for _ in range(T):
    n, m = [int(i) for i in input().split()]
    
    ind_edg_v = [True]*(3*n+1)
    ind_edg_e = [0]*n
    num_edg = 0
    
    for j in range(m):
        edge_0, edge_1 = [int(i) for i in input().split()]
        
        if num_edg < n:
            if ind_edg_v[edge_0] and ind_edg_v[edge_1]:
                ind_edg_e[num_edg] = j+1
                ind_edg_v[edge_0], ind_edg_v[edge_1] = False, False
                num_edg += 1
            
    if num_edg == n:
        print("Matching")
        print(' '.join([str(i) for i in ind_edg_e]))
    else:
        print("IndSet")
        vertex = 0
        for i in range(n):
            vertex += 1
            while not ind_edg_v[vertex]:
                vertex += 1
            print(vertex, end = ' ')
        print()