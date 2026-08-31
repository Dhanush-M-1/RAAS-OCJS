import sys

convert = {"1": {"1": "a", "2": "b", "3": "c", "4": "d", "5": "e"},
           "2": {"1": "f", "2": "g", "3": "h", "4": "i", "5": "j"},
           "3": {"1": "k", "2": "l", "3": "m", "4": "n", "5": "o"},
           "4": {"1": "p", "2": "q", "3": "r", "4": "s", "5": "t"},
           "5": {"1": "u", "2": "v", "3": "w", "4": "x", "5": "y"},
           "6": {"1": "z", "2": ".", "3": "?", "4": "!", "5": " "},
           }

for line in sys.stdin:
    line = line[:-1]

    if len(line) % 2 != 0:
        print("NA")
        continue

    message = ""

    line = iter(line)

    for first, second in zip(*[line, line]):

        if "1" <= first <= "6" and "1" <= second <= "5":
            message += convert.get(first).get(second)
        else:
            print("NA")
            break
    else:
        print(message)

