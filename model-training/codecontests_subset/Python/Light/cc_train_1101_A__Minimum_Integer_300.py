q = int(input())
L = [0]*q
R = [0]*q
D = [0]*q
for i in range(q):
    entrada = str(input()).split()
    L[i] = int(entrada[0])
    R[i] = int(entrada[1])
    D[i] = int(entrada[2])

def find_x(l,r,d):
    result = d
    if l <= d <= r:
        if  r % d == 0:
            result = r + d
        else:
            result = int(r/d)*d + d
    return result 
        

for i in range(q):
    print( find_x(L[i], R[i], D[i]))