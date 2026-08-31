n = int(input())
p = sorted(list(map(int,input().split())))
q = sorted(list(map(int,input().split())))
r = sorted(list(map(int,input().split())))
ans,ans1,bool,bool1 = 0,0,True,True
for num in range(n-2):
    if bool:
        if p[num] != q[num]:
            ans = p[num]
            bool = False
    if bool1:
        if q[num] != r[num]:
            ans1 = q[num]
            bool1 = False
if bool:
    ans = p[-2] if p[-2] != q[-1] else p[-1]
if bool1:
    ans1 = q[-1]
print(ans)
print(ans1)