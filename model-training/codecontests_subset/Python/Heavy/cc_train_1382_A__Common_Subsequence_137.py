iteration = int(input())
ans = []
for i in range(iteration):
    s = input().split(" ")
    l1 = int(s[0])
    l2 = int(s[1])
    a1 = input().split(" ")
    a2 = input().split(" ")
    arr = []
    done = False
    for x in a1:
        for y in a2:
            if x == y:
                arr.append(x)
                break
                done = True
        if done == True:
            breakp
    if len(arr) == 0:
        ans.append("NO")
    else:
        ans.append("YES")
        ans.append("1 "+arr[0])
for x in ans:
    print(x)
