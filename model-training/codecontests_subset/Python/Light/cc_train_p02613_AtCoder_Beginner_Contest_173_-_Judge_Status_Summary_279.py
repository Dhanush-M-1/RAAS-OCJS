n=int(input())
s=[]
for i in range(n):
    s.append(input())
for j in ['AC','WA','TLE','RE']:
    print(j+' x '+str(s.count(j)))