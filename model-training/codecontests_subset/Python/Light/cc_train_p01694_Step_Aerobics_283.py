def main():
    while True:
        n = int(input())
        if not n:
            return
        ls = False
        rs = False
        ns = True
        c = 0
        for f in input().split():
            if f == "lu":
                ls = True
            elif f == "ru":
                rs = True
            elif f == "ld":
                ls = False
            elif f == "rd":
                rs = False
            if ls == ns and rs == ns:
                c += 1
                ns = not ns
        print(c)
        

if __name__ == '__main__':
    main()
