from collections import Counter
n = int(input())
a1 = Counter(map(int, input().split()))
a2 = Counter(map(int, input().split()))
a3 = Counter(map(int, input().split()))
ans = []
for x in a1:
    if x not in a3:
        ans.append(x)
    else:
        if a1[x]-1 == a3[x]:
            ans.append(x)
        elif a1[x]-2 == a3[x]:
            ans.append(x)
            ans.append(x)

if ans[0] not in a2 or a1[ans[0]]-1 == a2[ans[0]]:
    print(ans[0])
    print(ans[1])
else:
    print(ans[1])
    print(ans[0])
