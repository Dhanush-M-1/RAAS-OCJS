'''
ID: essi
LANG: PYTHON3
TASK: self-contest.py
'''
n = int(input())
s = input()
d = {'A':0, 'F':0, 'I':0}
for i in s: d[i]+=1
res = 0
for i in s:
    if i != 'F':
        if i == 'I':
            if d['I'] == 1:
                res+=1
        else:
            if d['I'] == 0:
                res+=1
print(res)
