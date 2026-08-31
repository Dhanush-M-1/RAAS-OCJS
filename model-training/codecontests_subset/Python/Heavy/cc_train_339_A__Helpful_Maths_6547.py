'''docstring tanya go!'''
INPTD = str(input())

LST = [0]

if INPTD.find('+') != -1:
    LST = ([int(x) for x in INPTD.split('+')]) 
else:
    LST[0] = int(INPTD)

def qsort1(trgt_lst):
    pvt_pnt = trgt_lst[1]
    lesser = qsort1([x for x in trgt_lst[1:] if x < pvt_pnt])
    bigger = qsort1([x for x in trgt_lst[1:] if x >= pvt_pnt])
    return lesser + [pvt_pnt] + bigger

LST.sort()
endString = ''

for val in LST:
    endString += str(val) + '+'

lastchar = len(endString) - 1
endString2 = endString[:lastchar]

print(endString2)
