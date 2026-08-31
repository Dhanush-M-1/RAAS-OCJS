n = int(input());
A = list(map(int, input().split()));
B = [];
for q in range(1000000):
    B.append(0);
for q in range(len(A)):
    B[A[q]] = 1;
cnst = 1000000//2
for q in range(cnst):
    if B[cnst - q] == 1 or B[cnst + q + 1] == 1:
        break;
print(cnst - q - 1);