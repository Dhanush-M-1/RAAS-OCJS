string = input()

ones = 0
twos = 0
threes = 0
result = ""

for letter in string:
    if letter != "+":

        if letter == "1":
            ones += 1
        elif letter == "2":
            twos += 1
        elif letter == "3":
            threes += 1


while ones > 0:
    if twos == 0 and threes == 0 and ones == 1:
        result = result + "1"

    else:
        result = result + "1+"
    ones -= 1


while twos > 0:
    if threes == 0 and twos == 1:
        result = result + "2"

    else:
        result = result + "2+"
    twos -= 1


while threes > 0:
    if threes == 1:
        result = result + "3"

    else:
        result = result + "3+"
    threes -= 1

print(result)
