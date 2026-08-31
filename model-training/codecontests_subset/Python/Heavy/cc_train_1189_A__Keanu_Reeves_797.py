import sys

def main():
    strlen = int(sys.stdin.readline().rstrip())
    string = sys.stdin.readline().rstrip()
    zeroes = 0
    ones = 0
    out_strs = []
    if (strlen % 2 == 1):
        # string is good
        out_strs.append(string)
    else:
        for i in range(len(string)):
            if string[i] == '0':
                zeroes += 1
            else:
                ones += 1
        if zeroes != ones:
            # string is good
            out_strs.append(string)
        else:
            out_strs.append(string[0])
            out_strs.append(string[1:])
    print(len(out_strs))
    for item in out_strs:
        print(item, end=' ')

if __name__ == "__main__":
    main()
