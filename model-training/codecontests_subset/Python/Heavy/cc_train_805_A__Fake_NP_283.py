from sys import stdin, stdout

l, r = map(int, stdin.readline().split())

if (r - l > 10):
    stdout.write('2')
else:
    d = {}
    for i in range(l, r + 1):
        for j in range(1, min(int(i ** 0.5) + 1, i)):
            if not i % j:
                if j in d:
                    d[j] += 1
                else:
                    d[j] = 1
                
                if i // j in d:
                    d[i // j] += 1
                else:
                    d[i // j] = 1
    
    ans = (0, 0)
    for u in d:
        if u != 1 and d[u] > ans[0]:
            ans = (d[u], u)
    
    stdout.write(str(ans[1]))