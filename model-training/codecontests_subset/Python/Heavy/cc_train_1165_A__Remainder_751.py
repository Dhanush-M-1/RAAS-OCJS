import sys

moves = 0

input = sys.stdin.readlines()# ['2000 1 0', '11110100110001100000100101001001000110101101000011101010000010010101101100000']#  # ["11 5 2", "11010100101"]

# print(input)

n, x, y = map(int, input[0].split(" "))

num = input[1].strip()


if y == 0:
    moves += 0
else:
    ystr = num[-y:len(num)]
    moves += ystr.count("1")

xydelta = num[-x:-y-1]

moves += xydelta.count("1")

modchar = num[-y-1]

moves += 0 if modchar == "1" else 1
# moves
print(moves)
# input[1] == "11010100101"
# input[0] == "11 5 2"
