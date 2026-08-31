def func():
    s1, s2 = input().split()
    ss1 = list(s1)
    ss1_sort = sorted(ss1)
    ss2 = list(s2)
    lens = min(len(s1), len(s2))
    sortt = False
    for i in range(len(s1)):
        if (ss1[i] != ss1_sort[i]):
            pos = i
            sortt = True
            break
    if (sortt == False):
        if (s1 < s2):
            print(s1)
        else:
            print("---")
        return
    swap = -1
    for i in range(pos + 1, len(ss1)):
        if (ss1[i] == ss1_sort[pos]):
            swap = i
    ch = ss1[swap]
    ss1[swap] = ss1[pos]
    ss1[pos] = ch
    s1 = "".join(ss1)
    if (s1 < s2):
        print(s1)
    else:
        print("---")


t = int(input())
for i in range(t):
    func()