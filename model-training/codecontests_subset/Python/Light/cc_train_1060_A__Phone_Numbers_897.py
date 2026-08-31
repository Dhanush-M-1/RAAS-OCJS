import sys
# from copy import deepcopy


def main():
    inp = sys.stdin.readlines()
    amount_of_no = int(inp[0])
    string_of_no = str(inp[1]).strip()

    if amount_of_no < 11 \
            or not string_of_no.\
            __contains__("8"):
        print(0)
        return

    number_of_8 = string_of_no.count("8")
    no_set = set()
    no_list = [x for x in string_of_no]

    possibilities_len = int(len(no_list) / 11)
    possibilities_8 =  number_of_8
    possibilities = min(possibilities_8, possibilities_len)

    print(possibilities)




main()
