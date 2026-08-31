n,m = map(int,input().split(' '))
s = set()
for i in range(n):
    tmp = list(map(int, input().split()))
    for tmp in tmp[1:]:
        s.add(tmp)
print("YES" if len(s) == m  else "NO")