def getNewSum(sumstr):
    oc = 0;
    tc = 0;
    thc = 0;
    for i in range(0,len(sumstr)):
        if(sumstr[i]) == '1':
            oc += 1
        elif(sumstr[i]) == '2':
            tc += 1
        elif(sumstr[i]) == '3':
            thc += 1
    rstr = ""
    while oc != 0 or tc != 0 or thc != 0:
        if(oc >= 1):
            rstr += '1+'
            oc -= 1
        elif(tc >= 1):
            rstr += '2+'
            tc -= 1
        elif(thc >= 1):
            rstr += '3+'
            thc -= 1
    return rstr[:len(rstr)-1]

def main():
    print(getNewSum(input()))

if __name__ == "__main__":
    main()
