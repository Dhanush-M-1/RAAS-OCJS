#import sys
#sys.stdin=open('input.txt')
n = int(input())
s1 = list(map(int, input().split()))
s2 = list(map(int, input().split()))
s3 = list(map(int, input().split()))
m1 = dict()
m2 = dict()
m3 = dict()
for n in s1:
    if n in m1.keys():
        m1[n] += 1
    else:
        m1[n] = 1
for n in s2:
    if n in m2.keys():
        m2[n] += 1
    else:
        m2[n] = 1
for n in s3:
    if n in m3.keys():
        m3[n] += 1
    else:
        m3[n] = 1
for k in m1.keys():
    if k not in m2.keys():
        print(k)
        break
    else:
        if m2[k] != m1[k]:
            print( k)
            break
for k in m2.keys():
    if k not in m3.keys():
        print(k)
        break
    else:
        if m3[k] != m2[k]:
            print(k)
            break

