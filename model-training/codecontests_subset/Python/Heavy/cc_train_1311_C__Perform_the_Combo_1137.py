
tests = int(input())

for te in range(tests):
    n,m = list(map(int,input().split()))
    stringa = input()
    arr = list(map(int,input().split()))
    lista = [0 for i in range(n)]
    for i in range(m):
        lista[0] += 1
        lista[arr[i]] -= 1
    lista[0] += 1
    for i in range(1,n):
        lista[i] += lista[i-1]
    cnt = [0 for i in range(26)]
    for i in range(n):
        char = stringa[i]
        index = ord(char)-ord('a')
        cnt[index] += lista[i]

    print(*cnt)

    
