# =============================
#   Problem - 339A : Helpful Maths
#       Python3
#   Author - wdaubry
# =============================

def main():
    from sys import stdout

    inp = input()
    res_1 = ''
    res_2 = ''
    res_3 = ''
    for i in inp:
        if i == '3':
            res_3 += '+' + i
        elif i == '2':
            res_2 += '+' + i
        elif i == '1':
            res_1 += '+' + i

    res = res_1 + res_2 + res_3
    res = res[1:]

    stdout.write(str(res))

if __name__ == '__main__':
    main()
