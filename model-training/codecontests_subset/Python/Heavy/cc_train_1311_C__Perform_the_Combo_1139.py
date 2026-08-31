from sys import stdin

t = int(stdin.readline())

for _ in range(t):
    n, m  = list(map(int, stdin.readline().rstrip().split(" ")))
    s = stdin.readline().rstrip()
    p = list(map(int, stdin.readline().rstrip().split(" ")))

    prefixArr = [0] * (n + 1)
    prefixArr[0] = [0] * 26

    for i in range(n):
        prev = prefixArr[i].copy()
        prev[ord(s[i]) - 97] += 1
        prefixArr[i + 1] = prev
    
    output = prefixArr[-1].copy()

    #print(prefixArr)
    for i in range(m):
        for j in range(26):
            output[j] += prefixArr[p[i]][j]
    
    print(*output)




