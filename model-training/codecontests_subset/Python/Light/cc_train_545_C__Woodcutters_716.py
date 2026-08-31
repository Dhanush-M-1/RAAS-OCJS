n = int(input())
s = [[int(x) for x in input().split()] for _ in range(n)]
m = 2
if n==1:
    print(1)
else:
    for i in range(1,n-1):
        if s[i][0] - s[i-1][0] > s[i][1]:
            m += 1
        elif s[i+1][0] - s[i][0] > s[i][1]:
            m += 1 
            s[i][0] += s[i][1]
    
    print(m)