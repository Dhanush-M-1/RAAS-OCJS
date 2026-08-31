# import sys
# # For getting input from input.txt file
# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')
k = int(input())
st = input()
dt = {}
for i in st:
    dt[i] = dt.get(i,0) + 1
#print(dt)
mink,minv = '',0
maxv = 0
for ky,v in dt.items():
    if minv==0 and maxv == 0:
        minv = v
        maxv = v
    if minv > v:
        mink = ky
        minv = v
    if maxv < v:
        maxv = v
# print(minv,maxv)
if minv%k != 0 or maxv%k != 0:
    print(-1)
else:
    ans = ''
    tmpk = k
    while tmpk>0:
        for ky,v in dt.items():
            v //= k
            #print(ky,v)
            for i in range(v):
                ans+=ky
            #print(ans)
        tmpk-=1
    print(ans)
