def check(AL):
    for i in AL:
        if (i[:3].count('x')==2 and '.' in i[:3]) or (i[1:].count('x')==2 and '.' in i[1:]):
            return True
    B=[[0,0],[0,1],[1,0],[1,1]]
    C=[]
    for a,b in B:
        l=[]
        for i in range(3):l.append(AL[a+i][b+i])
        C.append(l)
    for i in C:
        if i.count('x')==2 and '.'in i:return True
    return False


A=[]
for i in range(4):A.append(input())
D=[]
for i in range(4):
    l=[]
    for j in range(4):
        l.append(A[j][3-i]) 
    D.append(l)
print('YES' if check(A) or check(D) else 'NO')
    


