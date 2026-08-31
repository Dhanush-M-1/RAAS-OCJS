if __name__ == '__main__' :
    n = int(input())
    str = input()
    s = 0
    for i in range(n) :
        if str[i] == '8' :
            s = s + 1
    print(min(n//11, s))