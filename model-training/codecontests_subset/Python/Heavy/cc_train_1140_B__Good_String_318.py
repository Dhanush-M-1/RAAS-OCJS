tsize = int(input())

# def solve(slen, string):
#     if string[0] == ">" or string[-1] == "<":
#         return 0

#     minrem = slen - 1
#     counting = 0
#     checking = string[0]
#     for i, s in enumerate(string):
#         if s == checking:
#             counting += 1
#         else:
#             minrem = min(minrem, counting)
            
#             if i != slen - 1:
#                 counting = 0
#                 checking = string[i+1]
#     return minrem


def solve(slen, string):
    if string[0] == ">" or string[-1] == "<":
        return 0

    ls = 0
    for c in string:
        if c == "<":
            ls += 1
        else:
            break
    
    rs = 0
    for c in reversed(string):
        if c == ">":
            rs += 1
        else:
            break
    return min(ls, rs)

for _ in range(0, tsize):

    slen = int(input())
    string = input()

    print(solve(slen, string))
