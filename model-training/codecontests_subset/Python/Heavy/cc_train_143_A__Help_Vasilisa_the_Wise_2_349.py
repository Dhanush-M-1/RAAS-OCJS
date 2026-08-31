from sys import stdin, stdout
INF=1e11
# import math
def get_int(): return int(stdin.readline().strip())
def get_ints(): return map(int,stdin.readline().strip().split()) 
def get_array(): return list(map(int,stdin.readline().strip().split()))
def get_string(): return stdin.readline().strip()
def op(c): return stdout.write(c)
# from collections import defaultdict 
# for _ in range(int(stdin.readline())):
r1,r2=get_ints()
c1,c2=get_ints()
d1,d2=get_ints()
arr=[[0,0],[0,0]]
f=0
for i in range(1,10):
    arr[0][0]=i
    for j in range(1,10):
        arr[0][1]=j
        for k in range(1,10):
            arr[1][0]=k
            for l in range(1,10):
                arr[1][1]=l
                if arr[0][0]+arr[0][1]==r1 and arr[1][0]+arr[1][1]==r2 and arr[0][0]+arr[1][0]==c1 and arr[0][1]+arr[1][1]==c2 and arr[0][0]+arr[1][1]==d1 and arr[1][0]+ arr[0][1]==d2:
                    s=set()
                    for x in range(2):
                        for y in range(2):
                            s.add(arr[x][y])
                    if len(s)<4:
                        continue
                    f=1
                    for x in range(2):
                        for y in range(2):
                            print(arr[x][y],end=" ")
                        print()
if f==0:
    print(-1)
