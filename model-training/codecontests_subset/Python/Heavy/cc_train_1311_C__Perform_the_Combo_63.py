import string

n = int(input())
d = dict()
d_reverse = dict()
d_ans = dict()
lst = string.ascii_lowercase
for i in range(n):
    for u in range(len(lst)):
        d[lst[u]] = u
        d_reverse[u] = lst[u]
        d_ans[lst[u]] = 0
    str_ans = ""
    ans = 0
    a, b = map(int, input().split())
    s = input()
    str_ = []
    for sd in s:
        str_.append(0)
    tries = list(map(int, input().split()))
    for h in tries:
        if h != 0:
            str_[h - 1] += 1
    str_[len(str_) - 1] = 1
    for j in range(1, len(str_)):
        str_[len(str_) - 1 - j] = str_[len(str_) - j] + str_[len(str_) - 1 - j]
    for k in range(len(str_)):
        charac = s[k]
        d_ans[charac] += str_[k]
    for h in list(string.ascii_lowercase):
        str_ans += str(d_ans[h]) + " "
    print(str_ans)
   