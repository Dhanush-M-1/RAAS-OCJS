N=int(input())
S = [input() for i in range(N)]
C=("AC","WA","TLE","RE")

for i in C:
    print(str(i)+" x "+str(S.count(str(i))))