# http://codeforces.com/problemset/problem/519/B

n = input()
err1 = sorted(input().split())
err2 = sorted(input().split())
err3 = sorted(input().split())

hasPrinted = False
for i in range(len(err2)):

    if err1[i] != err2[i]:
        print(err1[i])
        hasPrinted = True
        break

if hasPrinted == False:
    print(err1[len(err1) - 1])

hasPrinted = False
for i in range(len(err3)):

    if err2[i] != err3[i]:
        print(err2[i])
        hasPrinted = True
        break

if hasPrinted == False:
    print(err2[len(err2) - 1])