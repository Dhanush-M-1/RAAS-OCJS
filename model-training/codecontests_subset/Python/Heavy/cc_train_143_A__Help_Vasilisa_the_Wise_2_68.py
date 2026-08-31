r1, r2 = list(map(int, input().split()))
c1, c2 = list(map(int, input().split()))
d1, d2 = list(map(int, input().split()))

r1_contender = []
r2_contender = []
for i in range(1, 10):
    for j in range(1, 10):
        if i+j == r1 and i != j:
            r1_contender.append([i,j])
            r1_contender.append([j,i])
        if i+j == r2 and i != j:
            r2_contender.append([i,j])
            r2_contender.append([j,i])
found = False
for first_row in r1_contender:
    for second_row in r2_contender:
        colum1_match = (first_row[0] + second_row[0]) == c1
        colum2_match = (first_row[1] + second_row[1]) == c2
        diagnol1_match = (first_row[0] + second_row[1]) == d1
        diagnol2_match = (first_row[1] + second_row[0]) == d2
        if colum1_match and colum2_match and diagnol1_match and diagnol2_match and first_row[0] not in second_row and first_row[1] not in second_row:
            found=True
            print(' '.join(list(map(str, first_row))))
            print(' '.join(list(map(str, second_row))))
            break
    if found:
        break
if not found:
    print(-1)
