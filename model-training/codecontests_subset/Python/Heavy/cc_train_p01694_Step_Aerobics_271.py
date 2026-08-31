def identify(x:str, y:str):
    if (x == "lu" and y == "ru") or (x == "ru" and y == "lu"):
        return True
    if (x == "ld" and y == "rd") or (x == "rd" and y == "ld"):
        return True

while True:
    num = int(input())
    if num != 0:
        udlr = input()
        list_udlr = udlr.split()
        count = 0
        for i in range(num - 1):
            if identify(list_udlr[i], list_udlr[i + 1]):
                count += 1
                i += 2
        print(count)
    else:
        break
