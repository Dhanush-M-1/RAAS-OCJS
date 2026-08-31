def MakeSet(x):
     x.parent = x
     x.rank   = 0

def Union(x, y):
     xRoot = Find(x)
     yRoot = Find(y)
     if xRoot.rank > yRoot.rank:
         yRoot.parent = xRoot
     elif xRoot.rank < yRoot.rank:
         xRoot.parent = yRoot
     elif xRoot != yRoot: # Unless x and y are already in same set, merge them
         yRoot.parent = xRoot
         xRoot.rank = xRoot.rank + 1

def Find(x):
     if x.parent == x:
        return x
     else:
        x.parent = Find(x.parent)
        return x.parent

class Node:
    def __init__ (self, label):
        self.label = label
    def __str__(self):
        return self.label
    
if __name__ == '__main__':
    n = int(input())
    l = [Node(i) for i in range(n)]
    calles_cerrar = list()
    calles_abrir = list()
    [MakeSet(node) for node in l] #cada elemento posee su propio conjunto
    for i in range(n-1):
        a,b = list(map(int,input().strip().split()))
        if (Find(l[a-1]) != Find(l[b-1])):
            Union(l[a-1],l[b-1])
        else:
            calles_cerrar.append((a-1,b-1))
    for i in range(1,n):
        if (Find(l[0]) != Find(l[i])):
            calles_abrir.append((0,i))
            Union(l[0],l[i])
    print(len(calles_cerrar))
    for i in range(len(calles_cerrar)):
        lista = calles_cerrar[i] + calles_abrir[i]
        print(' '.join(str(p+1) for p in (lista)))
            
     
 



        
    
