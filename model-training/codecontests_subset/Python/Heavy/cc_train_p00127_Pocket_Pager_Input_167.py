def get_input():
    while True:
        try:
            yield ''.join(input())
        except EOFError:
            break

table = \
["afkpuz",\
 "bglqv.",\
 "chmrw?",\
 "dinsx!",\
 "ejoty "]

N = list(get_input())
for l in range(len(N)):
    str = N[l]
    ans = ""
    if len(str) % 2 == 1:
        ans = "NA"
    else:
        for i in range(0,len(str),2):
            x = str[i]
            y = str[i+1]
            if "1" <= x and x <= "6" and "1" <= y and y <= "5":
                ans = ans + table[int(y)-1][int(x)-1]
            else:
                ans = "NA"
                break

    print(ans)

