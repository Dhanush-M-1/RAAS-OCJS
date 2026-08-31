n = int(input())
q = [[int(j) for j in input().split()] for i in range(n)]
for i in range(n):
    if q[i][2] < q[i][0]:
        print(q[i][2])
    else:
        print((q[i][1]// q[i][2]+1)* q[i][2])
    
