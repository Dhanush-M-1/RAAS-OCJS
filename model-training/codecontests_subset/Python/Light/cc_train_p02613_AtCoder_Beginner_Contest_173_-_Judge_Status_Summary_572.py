n = int(input())
s = [input() for i in range(n)]
z = ['AC','WA','TLE','RE']

for j in z:
    print(j+' x '+str(s.count(j)))
