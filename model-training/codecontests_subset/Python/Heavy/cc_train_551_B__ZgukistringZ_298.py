import copy

a = input()
b = input()
c = input()

aa = {}
bb = {}
cc = {}


for i in 'abcdefghijklmnopqrstuvwxyz':
    aa[i] = 0
    bb[i] = 0
    cc[i] = 0

for i in a:
    aa[i] += 1

for i in b:
    bb[i] += 1

for i in c:
    cc[i] += 1

mx = 0
bmx = 0
cmx = 0

poss = 10**9
for i in 'abcdefghijklmnopqrstuvwxyz':
    if bb[i] != 0:
        poss = min(poss, aa[i]//bb[i])

for app in range(poss+1):
    cct = 10**9
    aa2 = copy.deepcopy(aa)
    for i in 'abcdefghijklmnopqrstuvwxyz':
        aa2[i] -= bb[i] * app

    for i in 'abcdefghijklmnopqrstuvwxyz':
        if cc[i] != 0:
            cct = min(cct, aa2[i] // cc[i])

    if app + cct > mx:
        mx = app + cct
        bmx = app
        cmx = cct

for i in 'abcdefghijklmnopqrstuvwxyz':
    aa[i] -= bb[i] * bmx

for i in 'abcdefghijklmnopqrstuvwxyz':
    aa[i] -= cc[i] * cmx

fnstr = (bmx*b+cmx*c)

for i in 'abcdefghijklmnopqrstuvwxyz':
    if aa[i] != 0:
        fnstr += i * aa[i]

print(fnstr)
