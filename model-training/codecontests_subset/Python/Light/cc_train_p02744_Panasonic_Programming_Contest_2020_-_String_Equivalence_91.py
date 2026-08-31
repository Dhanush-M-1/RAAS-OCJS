n = int(input())

ans = ["a"]

for i in range(n-1):
    old = ans
    ans = []
    for t in old:
        k = len(set(list(t)))
        for j in range(k+1):
            ans.append(t+chr(97+j))

print("\n".join(ans))