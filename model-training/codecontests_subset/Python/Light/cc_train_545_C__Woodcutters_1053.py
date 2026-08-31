n = int(input())
res = 1
ls = -9999999999
mat=[]
sat=[]
for i in range(n):
    x,y = map(int,input().split())
    mat.append(x)
    sat.append(y)

for j in range(n-1):
    if mat[j]-ls > sat[j]:
        res+=1
        ls = mat[j]
    elif mat[j+1] - mat[j] > sat[j]:
        res+=1
        ls = mat[j]+sat[j]
    else:
        ls = mat[j]
print(res)
