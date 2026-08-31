a, b, c = map(int, input().split())
ch1, ch2, ch3 = (a == 0), (b == 0), (c == 0)
if ch1 and ch2 and ch3:
    answer = -1
elif ch1 and ch2:
    answer = 0
elif (ch1 and ch3) or (ch2 and ch3):
    answer = 1
    answers = [0]
elif ch1:
    answer = 1
    answers = [-c/b]
elif ch2:
    if -c/a > 0:
        answer = 2
        answers = [-(-c/a)**0.5, (-c/a)**0.5]
    else:
        answer = 0
elif ch3:
    answer = 2
    answers = [-b/a, 0]
else:
    D = b**2 - 4*a*c
    if D > 0:
        answer = 2
        answers = [(-b+D**0.5)/(2*a), (-b-D**0.5)/(2*a)]
    elif D == 0:
        answer = 1
        answers = [-b/(2*a)]
    else:
        answer = 0
print(answer)
if answer > 0:
    for i in sorted(answers):
        print(i)
