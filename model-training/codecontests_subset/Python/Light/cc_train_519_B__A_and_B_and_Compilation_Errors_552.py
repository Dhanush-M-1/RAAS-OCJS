from collections import Counter
n=int(input())
l=[]
for i in range(3):
    a=str(input()).split(' ')
    a = list(map(int, a))
    l.append(a)
for i in range(len(l[:-1])):
    if list(set(l[i])-set(l[i+1]))==[]:
        for key, val in Counter(l[i]+l[i+1]).items():
            if val%2 == 1:
                print(key)
    else:
        print(list(set(l[i])-set(l[i+1]))[0])