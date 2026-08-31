button, lamp = map(int, input().split())
s = {i for i in range(1, lamp + 1)}
lamps = set()
for i in range(button):
    cnt = list(map(int, input().split()))
    lamps |= set(cnt[1:])
    
if lamps == s:
    print('YES')
else:
    print('NO')