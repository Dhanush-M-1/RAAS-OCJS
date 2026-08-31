N=int(input())
d={'AC':0,'WA':0,'TLE':0,'RE':0}
for _ in range(N):
    Si = input()
    d[Si] +=1
for k in d:
    print('{} x {}'.format(k,d[k]))