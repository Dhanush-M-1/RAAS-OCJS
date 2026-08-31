import copy
t = int(input())


def main():
    equalities = set()
    line, given = map(str, input().split())
    line = list(line)
    given = list(given)
    possible = 0
    m = 0
    for i in range(min(len(line), len(given))):
        if line[i] > given[i]:
            for k in range(len(line) - 1, i, -1):
                if given[i] > line[k]:
                    line[i], line[k] = line[k], line[i]
                    toret = ""
                    for m in line:
                        toret += m
                    print(toret)
                    return 0
                elif given[i] == line[k]:
                    if possible != 0 and k < len(given) and given[k] > line[i]:
                        possible = k
                    elif possible == 0:
                        possible = k
            m = i
            break
        if line[i] < given[i]:
            toret = ""
            for m in line:
                toret += m
            print(toret)
            return 0

        if line[i] == given[i]:
            equalities.add(i)

    if equalities:
        best = -1
        for i in range(len(line) - 1, -1, -1):
            if line[i] < line[best]:
                best = i
            if i in equalities:
                if line[best] < given[i]:
                    line[best], line[i] = line[i], line[best]
                    toret = ""
                    for m in line:
                        toret += m
                    print(toret)
                    return 0

    if len(equalities) == len(line) and len(given) > len(equalities):
        toret = ""
        for m in line:
            toret += m
        print(toret)
        return 0

    if possible == 0:
        print("---")
        return 0

    line[possible], line[m] = line[m], line[possible]
    for i in range(m, min(len(line), len(given))):
        if line[i] > given[i]:
            print("---")
            return 0
        if line[i] < given[i]:
            toret = ""
            for m in line:
                toret += m
            print(toret)
            return 0
    if len(given) > len(line):
        toret = ""
        for m in line:
            toret += m
        print(toret)
        return 0
    print("---")
    return 0


if __name__ == "__main__":
    for i in range(t):
        main()