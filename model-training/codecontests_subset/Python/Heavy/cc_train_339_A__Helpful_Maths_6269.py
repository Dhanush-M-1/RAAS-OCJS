def fixDigits(s):
    newList = []
    oneList = []
    twoList = []
    threeList = []
    for x in s:
        if x == "1":
            oneList.append(x)
        elif x == "2":
            twoList.append(x)
        elif x == "3":
            threeList.append(x)
    for y in oneList:
        newList.append(y)
        newList.append("+")
    for z in twoList:
        newList.append(z)
        newList.append("+") 
    for a in threeList:
        newList.append(a)
        newList.append("+")

    return "".join(newList[:-1])


if __name__ == "__main__":
    s = list(map(str,input().split("+")))
    print(fixDigits(s))
