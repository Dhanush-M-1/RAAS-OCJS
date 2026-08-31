n = int(input())
mat = [int(i) for i in input().split()]
mat2 = [int(i) for i in input().split()]
mat3 = [int(i) for i in input().split()]
mat.sort()
mat2.sort()
mat3.sort()
for i in mat2:
    mat.remove(i)
for j in mat3:
    mat2.remove(j)
print(mat[0])
print(mat2[0])
