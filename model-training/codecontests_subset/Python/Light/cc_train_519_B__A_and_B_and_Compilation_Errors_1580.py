def solve(si,sj):
    si.sort()
    sj.sort()
    for i,j in zip(si,sj):
        if i!=j:
            return j
    return sj[-1]
input()
ll=[]
for _ in range(3):
    ll.append(list(map(int,input().split())))
print(solve(ll[1],ll[0]))
print(solve(ll[2],ll[1]))
