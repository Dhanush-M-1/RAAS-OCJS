n = int(input())
for _ in range(n):
    ntests = int(input())
    tests = []
    for i in range(ntests):
        p, c = map(lambda x: int(x), input().split(" "))
        tests.append([p, c])
    prev_test = tests[0]
    if prev_test[1] > prev_test[0]:
        print("NO")
        continue
    skip=False
    for test in tests[1:]:
        if test[0] < prev_test[0]:
            print("NO")
            skip=True
            break
        if test[1] < prev_test[1]:
            print("NO")
            skip=True
            break
        if test[1] > prev_test[1] and test[0] <= prev_test[0]:
            print("NO")
            skip=True
            break
        if test[0] > prev_test[0]:
            if test[1] > prev_test[1] + test[0] - prev_test[0]:
                print("NO")
                skip = True
                break
        if test[1] > test[0]:
            print("NO")
            skip=True
            break
        prev_test = test
    if not skip:
        print("YES")
