N = int(input())
S = []
for i in range(N):
    S.append(input())
Result = ['AC', 'WA', 'TLE', 'RE']
 
for i in Result:
    print(i, 'x', S.count(i))