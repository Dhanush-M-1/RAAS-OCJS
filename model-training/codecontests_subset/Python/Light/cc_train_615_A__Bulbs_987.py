n, m = map(int, input().split())
ll = []
for i in range(n):
    k = list(map(int, input().split()))
    for j in range(1,k[0]+1):
        ll.append(k[j])
ll = set(ll)
ll = list(ll)
if ll == [int(i) for i in range(1,m+1)]:
    print('YES')
else:
    print('NO')