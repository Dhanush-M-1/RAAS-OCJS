t = int(input())
for i in range(t):
    n = int(input())
    a = [int(i) for i in input().split()]
    all = set()
    ans = [0, 0, 0]
    for i in range(n // 2):
        all.add(a[i])
    if len(all) < 3:
        print(0, 0, 0)
    else:
        new = []
        index = 0
        while index < n - 1:
            cnt = 1
            while index < n - 1 and a[index] == a[index + 1]:
                cnt += 1
                index += 1
            new.append([a[index], cnt])
            index += 1
        if a[-1] != new[-1][0]:
            new.append([a[-1], 1])
        ans = [new[0][1], 0, 0]
        index = 1
        s = 0
        while index < len(new) and new[index][1] + s <= ans[0]:
            s += new[index][1]
            index += 1
        if index < len(new):
            ans[1] = s + new[index][1]
        index += 1
        s = 0
        while index < len(new) and new[index][1] + s <= ans[0]:
            s += new[index][1]
            index += 1
        if index < len(new):
            ans[2] = s + new[index][1]
        all_sum = ans[0] + ans[1] + ans[2]
        index += 1
        while index < len(new) and (all_sum + new[index][1]) <= n // 2:
            ans[2] += new[index][1]
            all_sum += new[index][1]
            index += 1
        if (ans[0] < ans[2] and ans[0] < ans[1] and ans[0] * ans[1] * ans[2] != 0 and (ans[0] + ans[1] + ans[2]) <= n // 2):
            print(ans[0], ans[1], ans[2])
        else:
            print(0, 0, 0)