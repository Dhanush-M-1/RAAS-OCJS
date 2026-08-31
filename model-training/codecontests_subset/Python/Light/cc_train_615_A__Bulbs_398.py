n, m = map(int, input().split())

turn_on = set([])

for i in range(n):
    btns = list(map(int, input().split()))
    for b in btns[1:]:
        turn_on.add(b)

if len(turn_on) == m:
    print ("YES")
else:
    print ("NO")