def mysplit(s, a):
    interm = ""
    l = []
    for loc, i in enumerate(s):
        if i == a and interm.isnumeric():
            l.append(int(interm))
            interm = ""
        elif i == a and not interm.isnumeric():
            interm = ""
        elif i != a:
            interm += i
        if loc == len(s) - 1 and i != a:
            l.append(int(interm))
    return l


def myjoin(l, a):
    output_str = ""
    for loc, i in enumerate(l):
        if not loc == len(l) - 1:
            output_str += str(i) + a
    output_str += str(l[len(l) - 1])
    return output_str


def mymerge(l1, l2):
    output_list = []
    i, j = 0, 0
    while i < len(l1) and j < len(l2):
        if l1[i] < l2[j]:
            output_list.append(l1[i])
            i += 1
        else:
            output_list.append(l2[j])
            j += 1
    if i == len(l1):
        output_list += l2[j:]
    elif j == len(l2):
        output_list += l1[i:]
    return output_list


def mysort(l):
    if len(l) < 2:
        return l
    else:
        mid = len(l) // 2
        left = mysort(l[:mid])
        right = mysort(l[mid:])
        return mymerge(left, right)


def not_in_list(n, l):
    for i in l:
        if n == i:
            return False
    return True


def remove_dublicates(l):
    output_list = []
    output_list.append(l[0])
    i = 0
    j = 1
    while i < len(l) and j < len(l):
        if l[i] == l[j]:
            j += 1
        else:
            output_list.append(l[j])
            i = j
            j += 1
    return output_list




def main_function():
    a = input()
    l = []
    for i in range(int(a)):
        b = input()
        c = input()
        c = remove_dublicates(mysort(mysplit(c, " ")))
        l.append(len(c))
    return myjoin(l, "\n")


print(main_function())

