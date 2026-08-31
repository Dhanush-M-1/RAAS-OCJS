r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

ans = []
for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            for d in range(1, 10):
                if a + b == r1 and c + d == r2 and a + c == c1 and b + d == c2 and a + d == d1 and b + c == d2:
                    ans.append([a, b, c, d])
for i in range(len(ans)):
    if len(set(ans[i])) == 4:
        print(ans[i][0], ans[i][1])
        print(ans[i][2], ans[i][3])
        exit()
print(-1)
