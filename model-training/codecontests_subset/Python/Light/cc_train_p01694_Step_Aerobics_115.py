ans_list = []

while True:
    n = int(input())
    if n == 0:
        break
    S = input().split()
    cnt = 0
    dq = []
    for s in S:
        if not dq:
            dq.append(s)
        if [dq[-1], s] in [["lu","ru"],["ru","lu"],["ld","rd"],["rd","ld"]]:
            cnt += 1
            dq.append("@")
        else:
            dq.append(s)
    ans_list.append(cnt)

for ans in ans_list:
    print(ans)
