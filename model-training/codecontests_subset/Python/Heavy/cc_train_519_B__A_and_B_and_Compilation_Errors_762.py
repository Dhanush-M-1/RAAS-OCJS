'''
Created on Mar 6, 2015

@author: Praveen
'''
def printMissing(num, odict):
    temp = {}
    for i in range(0, len(num)):
        if num[i] not in temp:
            temp[num[i]] = 0
        temp[num[i]] = temp[num[i]] + 1
    ans = -1
    for key in odict.keys():
        if key not in temp:
            ans = key
            del odict[key]
            break
        elif temp[key] < odict[key]:
            ans = key
            odict[key] = temp[key]
            break
    stdout.write(str(ans) +"\n")


from sys import stdin, stdout
n = int(input())
num = [int(x) for x in stdin.readline().split()]
dict_numCount = {}
for i in range(0, len(num)):
    if num[i] not in dict_numCount:
        dict_numCount[num[i]] = 0
    dict_numCount[num[i]] = dict_numCount[num[i]] + 1  

num = [int(x) for x in stdin.readline().split()]
printMissing(num, dict_numCount)
num = [int(x) for x in stdin.readline().split()]
printMissing(num, dict_numCount)
