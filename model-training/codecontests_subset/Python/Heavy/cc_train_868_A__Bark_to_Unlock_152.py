password = input()
number = int(input())
S = []
k = 0


def check(x):
    if S[x] == password:
        return True
    tmp = S[x][0]
    for j, s in enumerate(S):
        if s[1] + tmp == password:
            return True

    tmp = S[x][1]
    for j, s in enumerate(S):
        if tmp + s[0] == password:
            return True
    return False


for i in range(number):
    tmp = input()
    S.append(tmp)

for i in range(number):
    if check(i) is True:
        k += 1
        print("YES")
        break

if k == 0:
    print("NO")