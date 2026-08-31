input()
errors = sorted(list(map(int, input().split())))
for i in range(2):
    pnt = 0
    new_err = sorted(list(map(int, input().split())))
    while pnt < len(new_err) and errors[pnt] == new_err[pnt]:
        pnt += 1
    print(errors[pnt])
    errors = new_err