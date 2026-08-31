from sys import stdin, stdout

class SOLVE:
    def bfs(self, src, node, color, A, B):  
        color[src]  = 0
        queue       = [src]
        while len(queue):
            u = queue[0]
            del queue[0]
            
            (A if color[u] else B).append(str(u))
            
            for v in node[u]:
                if color[v] == None:
                    color[v] = (color[u] ^ 1)
                    queue.append(v)
                elif color[v] == color[u]:
                    return 0
                
        return 1
    
    def solve(self):
        R = stdin.readline
        #f = open('input.txt');R = f.readline
        W = stdout.write
        
        n, m = [int(x) for x in R().split()]
        node = [[] for i in range(n+1)]
        for i in range(m):
            u, v = [int(x) for x in R().split()]
            node[u].append(v)
            node[v].append(u)
        
        A     = []
        B     = []
        color = [None for i in range(n+1)]
        for i in range(1, n+1):
            if len(node[i]) and color[i] == None:
                ret = self.bfs(i, node, color, A, B)
                
                if not ret:
                    W('-1\n')
                    return 0
                    
        W('%d\n' % len(A))
        W(' '.join(A) + '\n')
        W('%d\n' % len(B))
        W(' '.join(B) + '\n')
        
        return 0
        
def main():
    s = SOLVE()
    s.solve()
main()