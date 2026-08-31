from itertools import accumulate
import copy

S=input()
ANS=[0]
for s in S:
    if s=="0":
        ANS.append(-1)
    else:
        ANS.append(1)
SUM=list(accumulate(ANS))
MIN=[SUM[-1]]
for s in SUM[::-1][1:]:
    MIN.append(min(MIN[-1],s))
MIN.reverse()
MX=min(MIN)

ANS2=copy.deepcopy(ANS)
sa=0
for i in range(len(S)):
    if S[i]=="?":
        if MIN[i+1]-MX-sa>=2:
            ANS2[i+1]=-1
            sa+=2

ANS3=copy.deepcopy(ANS)
sa=0
MX-=1
for i in range(len(S)):
    if S[i]=="?":
        if MIN[i+1]-MX-sa>=2:
            ANS3[i+1]=-1
            sa+=2

S2=list(accumulate(ANS2))
S3=list(accumulate(ANS3))

print(min(max(S2)-min(S2),max(S3)-min(S3)))