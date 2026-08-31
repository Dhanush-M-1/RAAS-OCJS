def squizer(candels):
    global b
    global answer
    global ost
    while candels >= b:
        ost.append(candels % b)
        candels = candels // b
        answer.append(candels)
    ost.append(candels)


a, b = list(map(int, input().split()))
ost = []
answer = [a]
squizer(a)
c = sum(ost)
while c >= b:
    ost.clear()
    squizer(c)
    c = sum(ost)
print(sum(answer))
