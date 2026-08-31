StoneHeaps = []
R = []
S = 0
for i in range(int(input())):
    S1,S2,S3 = [int(_) for _ in input().split()]
    if S2==0:
        R.append(0)
        continue
    if S3>=2 and S2>=1:
        while True:
            if S3<2 or S2<1:
                break
            S3-=2
            S2-=1
            S+=3
    if S2>=2 and S1>=1:
        while True:
            if S2<2 or S1<1:
                break
            S2-=2
            S1-=1
            S+=3
    R.append(S)
    S = 0
for j in R:
    print(j)   