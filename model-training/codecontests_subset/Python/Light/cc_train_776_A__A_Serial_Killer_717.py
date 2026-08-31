mat = input().split()
num = int(input())
res = " ".join(i for i in mat) + "\n"
for _ in range(num):
    sat = input().split()
    if mat[0]==sat[0]: mat[0] = sat[1]
    else: mat[1] = sat[1]
    res += " ".join(i for i in mat) + "\n" 
print(res)

    

