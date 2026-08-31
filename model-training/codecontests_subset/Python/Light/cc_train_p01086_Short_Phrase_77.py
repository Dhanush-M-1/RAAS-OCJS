ans_list = []

def judge(array):
    res = 0
    cnt = 0
    st = [5,7,5,7,7,400]
    for a in array:
        res += len(a)
        if res > st[cnt]:
            return False
        if res == st[cnt]:
            cnt += 1
            res = 0
    if cnt == 5:
        return True

while True:
    n = int(input())
    if n == 0:
        break
    W = [input() for _ in range(n)]
    for i in range(n):
        part = W[i:]
        if judge(part):
            ans = i + 1
            break
    ans_list.append(ans)

for ans in ans_list:
    print(ans)
