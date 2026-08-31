A = int(input().strip())
B = sorted(list(map(int,input().strip().split())))
C = sorted(list(map(int,input().strip().split())))
D = sorted(list(map(int,input().strip().split())))

done = False
for i in range(len(C)):
    if C[i] != B[i]:
        print(B[i])
        done = True
        break
if not done:
    print(B[-1])

done = False
for i in range(len(D)):
    if C[i] != D[i]:
        print(C[i])
        done = True
        break
if not done:
    print(C[-1])