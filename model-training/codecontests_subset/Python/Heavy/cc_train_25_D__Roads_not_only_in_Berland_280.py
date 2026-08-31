n = int(input())
p = [i for i in range(n + 1)]
def asd(i):
    if  i != p[i]:
        p[i] = asd(p[i])
    return p[i]
def qwe(i, j):
    i = asd(i)
    j = asd(j)
    if i != j:
        p[i] = p[j]
        return True
    return False

l = list()
for i in range(n - 1):
    a, b = map(int, input().split())
    if not qwe(a, b):
        l.append((a, b))
        
print(len(l))
for i in l:
    for j in range(1, n + 1):
        if qwe(i[0], j):
            print(f"{i[0]} {i[1]} {i[0]} {j}")
            break
        
    

 	 			      	 	  					 			  		