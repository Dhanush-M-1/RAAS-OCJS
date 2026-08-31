def judge(string):
    if string[0] == "+":
        return 1
    elif string[0] == "-":
        return 2
    elif ":" in string:
        return 3
def get_text(string):
    idx = string.find(":")
    text = string[idx+1:]
    return text
def get_name(string):
    name = string[1:]
    return name
def main():
    import sys
    traffic = 0
    alist = []
    for line in sys.stdin:
        if judge(line) == 1:
            name = get_name(line)
            alist.append(name)
        elif judge(line) == 2:
            name = get_name(line)
            alist.remove(name)
        elif judge(line) == 3:
            t = get_text(line)
            traffic = traffic + (len(t)-1)*len(alist)
    print(traffic)
if __name__ == "__main__":
    main()
