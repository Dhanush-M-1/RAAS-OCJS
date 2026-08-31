_,*s=map(str,open(0).read().split())
c=['AC','WA','TLE','RE']
for i in range(4):
    print(c[i]+" x "+str(s.count(c[i])))