import string
import sys
input=lambda:sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n,m=map(int,input().split())
    s=input()
    p=[int(x)-1 for x in input().split()]
    arr=[[0 for _ in range(26)] for _ in range(n)]

    app = [0 for _ in range(26)]

    for i in range(n):
        app[ord(s[i]) - ord('a')] += 1
        for j in range(26):
            arr[i][j] = app[j]
        

    result = [0 for _ in range(26)]
    for i in p:
        for j in range(26):
            result[j] += arr[i][j]
    
    for j in range(26):
        result[j] += arr[n-1][j]

    print(' '.join([str(s) for s in result]))
