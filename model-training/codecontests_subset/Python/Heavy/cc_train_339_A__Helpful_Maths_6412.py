def arrangesum(inStr):
    sList = inStr.split("+")
    sListInts = []
    outStr = ""
    if len(inStr) <= 100:
        try:
            for x in sList:
                sListInts.append(int(x))
            sListInts.sort()
            outStr = str(sListInts[0])
            for y in range(len(sListInts)-1):
                outStr += "+" + str(sListInts[y+1])
            print(outStr)

        except(ValueError):
            outStr = "Error"
    else:
        print("Error")
        outStr = "Error"
    return outStr

s = input()
arrangesum(s)