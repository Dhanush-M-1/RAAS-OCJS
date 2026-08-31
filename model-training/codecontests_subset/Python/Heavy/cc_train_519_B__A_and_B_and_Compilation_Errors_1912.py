n = int(input())
d ={}
d1 = {}
for i in range(3):
    l = list(map(int,input().split()))
    for j in range(len(l)):
        if i == 0:
            if(l[j] in d) :
                d[l[j]] += 1
            else:
                d[l[j]] = 1
        elif i == 1:
            if(l[j] in d):
                d[l[j]] += 1
            if(l[j] in d1):
                d1[l[j]] += 1
            else:
                d1[l[j]] = 1
        elif i == 2:
            if(l[j] in d1):
                d1[l[j]] += 1
            else:
                d1[l[j]] = 1

for i in d:
    if d[i] % 2 != 0:
        print(i)
        break
for i in d1:
    if d1[i] % 2 != 0:
        print(i)
        break