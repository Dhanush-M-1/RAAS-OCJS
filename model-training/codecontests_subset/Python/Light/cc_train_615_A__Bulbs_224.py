n, m = map(int, input().split())
count = [0]*m
for i in range(n):
    _, *z = map(int, input().split())
    for ch in z: count[ch-1]+=1
print('YES' if all(ch>0 for ch in count) else 'NO')