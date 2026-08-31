def maths(string):
    # lst = list(map(str,string))
    # for i in range(0,len(lst)-1):
    #     if ( == "+"):
    #         lst.remove(lst[i])
    # return lst
    if len(string) <= 100:
        new = ""
        for i in range(0,len(string)):
            if string[i] != "+":
                new = new + string[i]
        newLST = list(map(int,new))
        newLST.sort()
        final = ""
        for i in range(0,len(newLST)):
            final += str(newLST[i])
            final += "+"
        return final[0:len(final)-1]
    else:
        return

if __name__ == "__main__":
    string = input()
    print(maths(string))
