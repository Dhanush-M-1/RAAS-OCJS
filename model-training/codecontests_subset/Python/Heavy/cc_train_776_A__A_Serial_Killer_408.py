__author__ = "Ryabchun Vladimir"

"""
##    ##  ######      ##      ##     ####     ##      ##    ###
##    ##    ##        ####  ####    ##  ##    ####    ##   #####
########    ##        ##  ##  ##    ##  ##    ## ##   ##   #####
########    ##        ##      ##   ########   ##   ## ##    ###
##    ##    ##        ##      ##  ##      ##  ##    ####
##    ##  ######      ##      ##  ##      ##  ##      ##    ###
"""

ans = []
fd = list(map(str, input().split()))
ans.append(fd)
n = int(input())
for i in range(1, n + 1):
    name1, name2 = map(str, input().split())
    aimin1 = list(ans[i-1])
    aimin1.remove(name1)
    ans.append([*aimin1, name2])
for line in ans:
    print(*line)