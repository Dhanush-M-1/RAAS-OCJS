from collections import Counter as c
n = int(input())
a = input()
if n>=11:
    eight = c(a)
    op = int(n/11)
    if eight["8"]>=op:
        print(op)
    elif eight["8"]<op:
        print(eight["8"])
    else:
        print(0)
else:
    print(0)
    