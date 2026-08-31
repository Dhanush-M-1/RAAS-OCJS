n, m = map(int, input().split())
x=[]
for i in range(n):
    x += list(map(int, input().split()))[1:]
print('YES' if len(set(x)) == m else 'NO')