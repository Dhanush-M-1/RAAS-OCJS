t = int(input())

for q in range(t):
    n = int(input())
    vetor = []
    flag = True
    for k in range(n):
        entrada = list(map(int, input().split(" ")))
        vetor.append(entrada)
    if(vetor[0][0] < vetor[0][1]):
        print("NO")
    else:
        for i in range(1, n):
            if((vetor[i][0] < vetor[i-1][0]) or (vetor[i][1] < vetor[i-1][1]) or (vetor[i][0] == vetor[i-1][0] and vetor[i][1] != vetor[i-1][1]) or (vetor[i][0]-vetor[i-1][0] < vetor[i][1]-vetor[i-1][1])):
                flag = False
                break
        if(flag == False):
            print("NO")
        else:
            print("YES")
        
