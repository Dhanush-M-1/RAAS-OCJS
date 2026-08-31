A = []
for i in range(4):
    A.append(input())
answer = False
answer_platform = ['xx.', 'x.x', '.xx']
for i in range(4):
    if A[i][0:3] in answer_platform or A[i][1:] in answer_platform:
        answer = True
    if A[0][i] + A[1][i] + A[2][i] in answer_platform or A[1][i] + A[2][i] + A[3][i] in answer_platform :
        answer = True
if A[1][0] + A[2][1] + A[3][2] in answer_platform or A[0][1] + A[1][2] + A[2][3] in answer_platform or A[0][0] + A[1][1] + A[2][2] in answer_platform or A[1][1] + A[2][2]+A[3][3] in answer_platform:
    answer = True
if A[0][2] + A[1][1] + A[2][0] in answer_platform or A[1][3] + A[2][2] + A[3][1] in answer_platform or A[0][3] + A[1][2] + A[2][1] in answer_platform or A[1][2] + A[2][1] + A[3][0] in answer_platform:
    answer = True
if answer:
    print("YES")
else:
    print("NO")

