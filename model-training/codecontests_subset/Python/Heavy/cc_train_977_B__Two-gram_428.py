n = int(input())
s = str(input())
S1 = []
S2 = []
i = 0
while i <= n-2:
    S1.append(s[i]+s[i+1])
    i+=2
i = 1
while i <= n-2:
    S2.append(s[i]+s[i+1])
    i+=2
S = S1 + S2
S = sorted(S,key=lambda x:x[0])
S = sorted(S,key=lambda x:x[1])
k = len(S)
SS = []
c = 1
for i in range(1,k):
    if S[i] == S[i-1]:
        c = c + 1
    else:
        SS.append(c)
        c = 1
    if i == k - 1:
        SS.append(c)
if SS != []:      
    a = max(SS)
    f = SS.index(a)
    p = 0
    for i in range(0,f+1):
        p = p + SS[i]
    print(S[p-1])
else:
    print(S[0])