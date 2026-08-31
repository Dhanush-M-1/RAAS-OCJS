import re

def special_match(str, search=re.compile(r'[^1-3+]').search):
    return  not bool(search(str))

if __name__ == "__main__":
    inputstring = input()
    if(inputstring.__len__() >= 0 & inputstring.__len__() <= 100):
        if (special_match(inputstring)):
            sumData = inputstring.split('+')
            sumData.sort()
            outputString = ""
            for index in range(sumData.__len__()):
                if (sumData[index] == ""):
                    exit(0)
                if (sumData.__len__() ==1 or index == sumData.__len__()-1): 
                    outputString += ""+ sumData[index]
                    continue
                outputString += "" +sumData[index]+"+"
            print(outputString)
