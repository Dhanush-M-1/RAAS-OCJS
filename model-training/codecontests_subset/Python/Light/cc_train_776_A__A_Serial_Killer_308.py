import re
sk=[input().split()]
n=int(input())
for x in range(n):
    n1=input().split()
    if re.match(sk[x][0],n1[0]) and re.match(n1[0],sk[x][0]):
        sk.append([n1[1],sk[x][1]])
    else:
        sk.append([sk[x][0],n1[1]])
for x in range(n+1):
    print(sk[x][0],sk[x][1])
