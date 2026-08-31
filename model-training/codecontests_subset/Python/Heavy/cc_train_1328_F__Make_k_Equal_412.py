import sys
input = sys.stdin.readline

from collections import Counter

n,k=map(int,input().split())
A=list(map(int,input().split()))

S=sorted(set(A))+[1<<60]
C=Counter(A)

if max(C.values())>=k:
    print(0)
    sys.exit()

L=[0]
LK=[0]
ko=0
for i in range(len(S)-1):
    ko+=C[S[i]]
    LK.append(ko)
    L.append(L[-1]+ko*(S[i+1]-S[i]))

R=[0]*len(S)
RK=[0]*len(S)
ko=0
for i in range(len(S)-1,-1,-1):
    ko+=C[S[i]]
    RK[i-1]=ko
    R[i-1]=(R[i]+ko*(S[i]-S[i-1]))
R[-1]=0
ANS=1<<61
for i in range(len(S)-1):
    rest=k-C[S[i]]

    if i>=1:
        if rest<=LK[i]:
            ANS=min(ANS,L[i-1]+(S[i]-S[i-1])*rest)
        else:
            ANS=min(ANS,L[i]+R[i+1]+(S[i+1]-S[i])*RK[i]-(RK[i]-rest+LK[i]))

    if i<len(S)-1:
        if rest<=RK[i]:
            ANS=min(ANS,R[i+1]+(S[i+1]-S[i])*rest)
        else:
            ANS=min(ANS,R[i]+L[i-1]+(S[i]-S[i-1])*LK[i]-(LK[i]-rest+RK[i]))

print(ANS)
    

    
    



