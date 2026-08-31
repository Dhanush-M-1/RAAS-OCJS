n,m=[int(x) for x in input().split()]
num=0
record = [0 for i in range(m)]
for i in range(n):
    si=[int(x) for x in input().split()]
    a=len(si)
    for i in range(1,a):
        if record[si[i]-1] == 0:
            record[si[i]-1] = 1
for i in range(m):
    if record[i] == 0:
        print('No')
        break
    elif i == m-1:
        print("Yes")