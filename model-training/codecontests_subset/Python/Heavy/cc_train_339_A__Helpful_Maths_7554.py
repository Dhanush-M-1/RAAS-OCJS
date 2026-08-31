str_input = list(input())
str_len = len(str_input)
if str_len == 1:
    str_input = "".join(str_input)
    print(str_input)
else:
    pos = 1
    while pos < str_len:
        del(str_input[pos])
        pos += 1
        str_len -= 1
    pos = 0
    str_len = len(str_input)
    while pos < str_len:
        str_input[pos] = int(str_input[pos])
        pos += 1
    str_input.sort()
    pos = 0
    while pos < str_len:
        str_input[pos] = str(str_input[pos])
        pos += 1
    pos = 1
    while pos < str_len:
        str_input.insert(pos,"+")
        pos += 2
        str_len += 1
    str_input = "".join(str_input)
    print(str_input)
