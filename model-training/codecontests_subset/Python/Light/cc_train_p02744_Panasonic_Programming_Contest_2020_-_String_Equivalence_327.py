
N = int(input())
S = "abcdefghij"
ans = [""]
for k in range(N):
    n = []
    for e in ans:
        for f in S[:len(set(str(x) for x in e))+1]:
            n.append(e+f)
    ans = n
ans = sorted(ans)
for e in ans:
    print(e)
