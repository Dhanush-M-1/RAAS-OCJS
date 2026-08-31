n = int(input())
errors = []
for i in range(3):
    cur = [int(x) for x in input().split()]
    err = {}
    for j in range(len(cur)):
        if cur[j] in err:
            err[cur[j]] += 1
        else:
            err[cur[j]] = 1
    errors.append(err)
for i in range(2):
    for x in errors[i]:
        if x not in errors[i + 1] or errors[i][x] > errors[i + 1][x]:
            print(x)
            break