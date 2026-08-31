N = int(input())
S = [input() for X in range(0,N)]
for T in ['AC','WA','TLE','RE']:
    print('{0} x {1}'.format(T,S.count(T)))