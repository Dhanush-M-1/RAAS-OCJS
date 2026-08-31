import math
data = [int(x) for x in input().split()]
a = data[0]
b = data[1]
c = data[2]
if a == 0 and b == 0 and c == 0:
    print(-1)
elif a == 0 and b == 0:
    print(0)
elif a == 0 and b != 0:
    print(1)
    print(-c/b)
elif (b ** 2) - (4 * a * c) < 0:
    print(0)
else:
    ans1 = (-b + math.sqrt((b ** 2) - (4 * a * c)))/(2*a)
    ans2 = (-b - math.sqrt((b ** 2) - (4 * a * c)))/(2*a)
    if ans1 == ans2:
        print(1)
        print(ans1)
    else:
        answers = [ans1,ans2]
        answers.sort()
        print(2)
        print(answers[0])
        print(answers[1])
