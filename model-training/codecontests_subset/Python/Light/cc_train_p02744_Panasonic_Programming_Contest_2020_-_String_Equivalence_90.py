n = int(input())
ans = ['a']

for i in range(n-1):
    buf = []
    for j in ans:
        l = len(set(j))
        for c in range(l+1):
            buf.append(j+chr(ord('a')+c))
    ans = buf

for i in ans:
    print(i)