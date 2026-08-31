# Author: Chan Jun Wei
# Website: Codeforces
# Problem: 339 A: Helpful Maths
# Link: http://codeforces.com/problemset/problem/339/A

def sortSum(sumString):
    delimeters = '+'
    sumIntStrs = sumString.split(delimeters)
    sumInts = []
    for sumIntStr in sumIntStrs:
        sumInt = int(sumIntStr)
        sumInts.append(sumInt)
    sumInts.sort()
    sortedAns = str(sumInts[0])
    for i in range(1, len(sumInts)):
        sortedAns += delimeters + str(sumInts[i])
    return sortedAns

sumString = input()
print(sortSum(sumString))
