[no_intrerupatoare, no_becuri] = [int(x) for x in input().strip().split()]

v = [0] * 101

for i in range(no_intrerupatoare):
    becuri = [int(x) for x in input().strip().split()]
    for x in becuri[1:]:
        v[x] = 1

if sum(v) == no_becuri:
    print("YES")
else:
    print("NO")
