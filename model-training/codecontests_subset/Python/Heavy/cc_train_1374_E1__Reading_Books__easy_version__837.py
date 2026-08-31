##  *********************************************
##  *                                           *
##  *  |  |  \     / |-     |\    ---  |\    |  *
##  *  |  |   \   /  |  \   | |  |   | | \   |  *
##  *  |--|    \ /   |   |  |/   |   | |  \  |  *
##  *  |  |     /    |  /   | \  |   | |   \ |  *
##  *  |  |    /     |-     |  \  ---  |    \|  *
##  *                                           *
##  *********************************************

n, k = map(int, input().split())
t=list()
a=list()
b=list()
alice=list()
bob=list()
both=list()
for i in range(0, n):
      x, y, z = map(int, input().split())
      if y and z:
            both.append(x)
      else:
            if y:
                  alice.append(x)
            else:
                  if z:
                        bob.append(x)
alice.sort()
bob.sort()
both.sort()
INF = 200000000000
res = INF
if len(alice) > 1:
      for i in range(1, len(alice)):
            alice[i] += alice[i-1]
if len(bob) > 1:
      for i in range(1, len(bob)):
            bob[i] += bob[i-1]
if len(both) > 1:
      for i in range(1, min(k, len(both))):
            both[i] += both[i-1]

if not((len(alice)) * (len(bob))):
      if len(both) < k:
            res = -1
      else:
            res = both[k-1]
else:
      if not(len(both)):
            if len(bob) >= k and len(alice) >= k:
                  res = bob[k-1] + alice[k-1]
            else:
                  res = -1
      else:
            for cnt in range(1, len(both)+1):
                  if cnt > k:
                        break
                  i = k - cnt - 1
                  if i == -1:
                        res = min(res, both[cnt-1])
                        break
                  if i < len(alice) and i < len(bob):
                        res = min(res, both[cnt-1] + alice[i] + bob[i])
            if k <= len(alice) and k <= len(bob):
                  res = min(res, alice[k-1] + bob[k-1])
if res == INF:
      print(-1)
else:
      print(int(res))

##              1
##              *
##             ***
##            *****
##      \    **000**    /
##       \  ***0|0***  /
##         ****000****
##        *************
##       ***************
##      *****************
##         .|       |.
