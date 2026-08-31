T = int(input())

def solve():
    N = int(input())
    PC = []
    for _ in range(N):
        [p,c] = list(map(int,input().split()))
        PC.append([p,c])

    for i in range(N):
        if i == 0:
            if PC[i][1] > PC[i][0]:
                return "NO"
            continue
        
        delta_p = PC[i][0]-PC[i-1][0]
        delta_c = PC[i][1]-PC[i-1][1]

        if PC[i][1] > PC[i][0]:
            return "NO"

        if delta_p < 0 or delta_c < 0:
            return "NO"

        if delta_c > delta_p:
            return "NO"
    return "YES"


for _ in range(T):
    print(solve())

