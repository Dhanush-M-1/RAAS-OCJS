n = int(input())
act = []
for i in range(n):
    x, h = map(int, input().split())
    act.append([[x - h, x], [x, x + h]])
fall = [act[0][0]]
for i in range(1, len(act) - 1):
    if act[i][0][0] > act[i - 1][0][1]:
        fall.append(act[i][0])
    if act[i][1][1] < act[i + 1][0][1]:
        fall.append(act[i][1])
fall.append(act[-1][1])
# print(fall)
fall = sorted(fall, key=lambda x: x[1])
# print(fall)

ans = 1
last = fall[0]

for i in fall[1:]:
    if i[0] > last[1]:
        # print(last)
        last = i
        ans += 1
print(ans)
