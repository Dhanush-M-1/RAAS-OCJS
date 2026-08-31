"""def append(s):
    arr = list(s)
    if arr[-1] == 'z':
        arr[-1] = 'a'
        i = -2
        while -1 * i <= len(s) and arr[i] == 'z'  :
            arr[i] = 'a'
            i = i - 1
        if -1 * i > len(s):
            arr= ['a'] + arr
        else:
            arr[i] = d[arr[i]]
    else:
        arr[-1] = d[arr[-1]]
    return ''.join(arr)

k = int(input())
s = input()
t = input()

import string
alph = list(string.ascii_lowercase)
alphb = alph[1:] + [alph[0]]
d = dict(zip(alph, range(26)))
print(d)
l = [s]
el = s

while el != t:
    el = append(el)
    l.append(el)

print(l)
middleIndex = (len(l) - 1)/2
print(l[int(middleIndex)])"""


n = int(input())
arr = input().split()
arr = [int(x) for x in arr]

chet_arr = []
nechet_arr = []
for x in arr:
    if x % 2 == 0:
        chet_arr.append(x)
    else:
        nechet_arr.append(x)

if abs(len(chet_arr) - len(nechet_arr)) < 2:
    print(0)
else:
    r = len(nechet_arr) - len(chet_arr)
    if r > 0:
        nechet_arr.sort()
        print(sum(nechet_arr[0:r-1]))
    else:
        r = -1 * r
        chet_arr.sort()
        print(sum(chet_arr[0:r-1]))




    
