from bisect import bisect_right

n = int(input())
first = list(map(int,input().split()))
e1_count = {}
e2_count = {}
e3_count = {}
for e in first:
    try:
        e1_count[e]+=1
    except:
        e1_count[e]=1
        e2_count[e]=0
        e3_count[e]=0

second = list(map(int,input().split()))
for e in second:
    e2_count[e]+=1
third = list(map(int,input().split()))
for e in third:
    e3_count[e]+=1

#1 3 3 4 5 7
#3 3 4 5 7 
#3 4 5 7
for e1 in e1_count:
    if e1_count[e1]!=e2_count[e1]:
        print(e1)
        break
for e2 in e2_count:
    if e2_count[e2]!=e3_count[e2]:
        print(e2)
        break
