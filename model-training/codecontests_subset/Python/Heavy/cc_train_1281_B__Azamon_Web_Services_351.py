# ":"
t = int(input())
for _ in range(t):
    s1, s2 = input().split()
    correct = "".join(sorted(s1))
    val = change = -1
    #print(correct)
    for i in range(len(s1)):
        if s1[i] != correct[i]:
            val = correct[i]
            change = i
            break
    #print(val,change)
    if val != -1 and change != -1:
        for i in range(change, len(s1)):
            if s1[i] == val:
                change1 = i
        s_fin = ""
        for i in range(len(s1)):
            if i == change:
                s_fin += s1[change1]
            elif i == change1:
                s_fin += s1[change]
            else:
                s_fin += s1[i]
        s_fin = "".join(s_fin)
    else:
        s_fin = s1
    if s_fin >= s2:
        print("---")
    else:
        print(s_fin)
