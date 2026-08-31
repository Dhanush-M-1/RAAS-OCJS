answer = 0
n = int(input())
T = [[-10**10,0]] + [[int(x) for x in input().split()] for i in range(n)] + [[10**10,0]]
for x in range(1,n+1):
    if T[x][0] - T[x-1][0] > T[x][1]:
        answer += 1
    elif T[x+1][0] - T[x][0] > T[x][1]:
        answer += 1 
        T[x][0] += T[x][1] 
print(answer)