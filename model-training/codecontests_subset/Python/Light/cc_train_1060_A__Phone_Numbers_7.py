n = int(input())
eights = 0
others = 0
for elem in input():
    if int(elem) == 8:
        eights += 1
    else:
        others += 1
answer = 0
while True:
    if eights == 0:
        break
    else:
        eights -= 1
        if others >= 10:
            others -= 10
            answer += 1
        else:
            if eights - (10 - others) >= 0:
                eights -= (10 - others)
                others = 0

                answer += 1
            else:
                break
    
print(answer)