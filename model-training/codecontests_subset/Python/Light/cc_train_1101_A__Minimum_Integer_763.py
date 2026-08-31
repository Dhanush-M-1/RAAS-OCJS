original_length = int(input())
questions = []
for x in range(original_length):
    questions.append([int(y) for y in input().split()])
for i in questions:
    d = int(i[2])
    if d >= i[0]:
           print((i[1] // d + 1) * d)
    else:
        print(d)