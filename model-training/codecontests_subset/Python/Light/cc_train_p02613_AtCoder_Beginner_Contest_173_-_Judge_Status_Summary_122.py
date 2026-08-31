N=int(input())
S=[]
for i in range(N):
    S.append(input())
    
for i in ['AC', 'WA','TLE','RE']:
    print(i+' '+'x'+' '+str(S.count(i)))