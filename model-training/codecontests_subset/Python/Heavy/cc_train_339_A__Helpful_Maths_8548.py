inp = input()
plus = 1
one = 0
two = 0
three = 0
answer = ""
for x in range(len(inp)):
    if inp[x] == "+":
        plus = plus + 1
    elif inp[x] == "1":
        one = one + 1
    elif inp[x] == "2":
        two = two + 1
    else:
        three = three + 1

while plus > 0:
    if one > 0:
        answer = answer + "1"
        one = one - 1
    elif two > 0:
        answer = answer + "2"
        two = two - 1
    elif three > 0:
        answer = answer + "3"
        three = three - 1
    if plus > 1:
        answer = answer + "+"
    plus = plus - 1
print(answer)