n = int(input())


s1 = 0 
ans = []
for i in range(3):
    l = list(map(int,input().split()))

    s = sum(l)

    ans.append(s1-s)

    s1 = s

print(ans[1])
print(ans[2])
