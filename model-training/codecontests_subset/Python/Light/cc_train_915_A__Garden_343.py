n,k = map(int,input().split())
mat = sorted(list(map(int,input().split())))[::-1]
for i in mat:
    if k % i == 0:
        print(k//i)
        break
