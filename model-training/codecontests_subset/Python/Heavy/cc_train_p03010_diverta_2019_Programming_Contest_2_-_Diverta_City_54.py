N = int(input())

s = []
t = []
i = 1
while len(s) < N :
    if i in t or any(i + s_ in t for s_ in s) :
        i += 1
        continue
    
    t.append(i)
    for s_ in s :
        t.append(i+s_)
    
    s.append(i)
    i += 1

w = [[0] * 10 for _ in range(10)]
w[0][1] = w[1][0] = 1

M = 1
for n in range(3, N + 1) :
    M += 1
    for i in range(n-1) :
        w[i][n-1] = w[n-1][i] = M * s[i]
        
    M += w[n-1][n-2] + w[n-1][n-3] - w[n-2][n-3] - 1
    
for i in range(N) :
    print(' '.join([str(j) for j in w[i][:N]]))