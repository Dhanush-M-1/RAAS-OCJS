__author__ = 'Rakshak.R.Hegde'
"""
Created on Dec 14 2014 PM 12:39

@author: Rakshak.R.Hegde
"""

s = input()
lastH = s.rfind('#')
countBr = 0
for i in range(lastH):
    if s[i] == '(':
        countBr += 1
    else:
        countBr -= 1
    if countBr < 0:
        break
else:
    nco = s.count('(', lastH + 1)
    ncc = s.count(')', lastH + 1)
    cntExtraC = countBr + nco - ncc
    countBr -= cntExtraC
    if cntExtraC > 0 and countBr >= 0:
        for i in range(lastH + 1, len(s)):
            if s[i] == '(':
                countBr += 1
            else:
                countBr -= 1
            if countBr < 0:
                break
        else:
            countH = s.count('#')
            print('1\n' * (countH - 1) + str(cntExtraC))
            exit(0)
print('-1')