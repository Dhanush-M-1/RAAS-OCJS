s = input()
n = int(input())
l1, l2, l = [] , [], []
for i in range(n):
    tp = input()
    l.append(tp)
    l1.append(tp[0])
    l2.append(tp[1])
if s in l or s[::-1] in l:
    print('YES')
else:    
    if ((s[0] in l2) and (s[1] in l1)):
        print('YES')
    else:
        print('NO')