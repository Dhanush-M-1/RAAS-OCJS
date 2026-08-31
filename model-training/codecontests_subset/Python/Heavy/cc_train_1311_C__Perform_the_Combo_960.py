import sys
T = int(sys.stdin.readline())
for _ in range(T):
    n, m = map(int, sys.stdin.readline().split())
    s = sys.stdin.readline().strip()
    p = list(map(int, sys.stdin.readline().split()))
    p.sort()
    dict_alpha = {chr(97+i):i for i in range(26)}
    list_count = [0]*26
    list_result = [0]*26
    j = 0
    for i, letter in enumerate(s):
        list_count[dict_alpha[letter]] += 1
        list_result[dict_alpha[letter]] += 1
        if j<m and i == p[j]-1:
            gop = 0
            while j<m and i == p[j]-1:
                gop += 1
                j+=1
            for k in range(26):
                list_result[k]+=list_count[k]*gop
        
    print(*list_result)

