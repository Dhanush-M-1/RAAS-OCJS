from math import ceil
def main():
    p = 1
    m = 0
    n = 0
    exp = str(input()).split(' ')
    for i in range(len(exp)):
        if exp[i] == '+':
            p += 1
        elif exp[i] == '-':
            m += 1
        elif exp[i] == '=':
            n = int(exp[i+1])
    

    if p > n + m * n:
        print("Impossible")
        return


    result = n + m
    if p <= result:
        required = ceil(result / n)

        if p >= required:
            print("Possible")
        else: 
            print("Impossible")
            return
        
        pVal = result // p
        pRem = result % p

        isMinus = False
        s_out = ""
        for i in range(len(exp)):
            if exp[i] == '?':
                if not isMinus:
                    val = pVal
                    if pRem > 0:
                        val += 1
                        pRem -= 1
                    s_out += str(val) + " "
                else:
                    s_out += "1 "
            else:
                if exp[i] == '-':
                    isMinus = True
                elif exp[i] == '+':
                    isMinus = False
                else:
                    s_out += exp[i] + " " + exp[i+1]
                    break
                s_out += exp[i] + " "

        print(s_out)
    else:
        print("Possible")
        comp = p - n
        mVal = comp // m
        mRem = comp % m

        isMinus = False
        s_out = ""
        for i in range(len(exp)):
            if exp[i] == '?':
                if isMinus:
                    val = mVal
                    if mRem > 0:
                        val += 1
                        mRem -= 1
                    s_out += str(val) + " "
                else:
                    s_out += "1 "
            else:
                if exp[i] == '-':
                    isMinus = True
                elif exp[i] == '+':
                    isMinus = False
                else:
                    s_out += exp[i] + " " + exp[i+1]
                    break
                s_out += exp[i] + " "

        print(s_out)



main()