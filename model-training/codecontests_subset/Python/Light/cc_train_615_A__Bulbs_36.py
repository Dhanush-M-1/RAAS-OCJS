readInts=lambda: list(map(int, input().split()))
n,m=readInts()
s=set()
for i in range(n):
    s|=set(readInts()[1:])
print('YES' if len(s)==m else 'NO')

