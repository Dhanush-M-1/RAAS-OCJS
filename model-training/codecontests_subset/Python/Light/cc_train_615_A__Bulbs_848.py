n,m = map(int, input().split())
given = set(range(1,m+1))
maken = set()
for i in range(n):
    for elem in (map(int, input().split()[1::])):
        maken.add(elem)
print("YES" if given.issubset(maken) else "NO")
