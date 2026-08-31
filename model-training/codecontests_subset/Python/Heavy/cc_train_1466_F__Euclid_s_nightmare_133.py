from collections import defaultdict,deque
import sys
import bisect
import math
input=sys.stdin.readline
mod=1000000007

class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))

    def find(self, a):
        acopy = a
        while a != self.parent[a]:
            a = self.parent[a]
        while acopy != a:
            self.parent[acopy], acopy = a, self.parent[acopy]
        return a

    def union(self, a, b):
        self.parent[self.find(b)] = self.find(a)

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
UF = UnionFind(m + 1)
MOD = 10 ** 9 + 7

out = []
for i in range(1, n + 1):
    l = list(map(int, input().split()))
    if len(l) == 2:
        u = 0
        v = l[1]
    else:
        #if vector contains two cordinates equal to one, then it means they are
        #connected, that s we cannot count one without counting the other
        _, u, v = l        
    uu = UF.find(u)
    vv = UF.find(v)
    #if any edge forms a cycle then discard that edge, as it's function is redundant
    if uu != vv:
        UF.union(uu,vv)
        out.append(i)

print(pow(2, len(out), MOD), len(out))
print(' '.join(map(str,out)))

    
    

           
                


    
    
       
            


    
    
        
    

        

           
                


    
    

           
                


    
    
       
            


    
    
        
    
                


    
    

           
                


    
    
       
            


    
    
        
    

        

           
                


    
    

           
                


    
    
       
            


    
    
        
    

        

           
                


    
    

           
                


    
    
       
            


    
    
        
    


           
                


    
    

           
                


    
    
       
            


    
    
        
    

        

           
                


    
    

           
                


    
    
       
            


    
    
        
    

        

           
                


    
    

           
                


    
    
       
            


    
    
        
    
