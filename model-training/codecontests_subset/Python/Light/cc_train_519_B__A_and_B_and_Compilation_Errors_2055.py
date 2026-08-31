def A_and_B_and_Compilation_Errors(li1, li2, li3):
    li1.sort()
    li2.sort()
    li3.sort()
    for i in range(len(li2)):
        if li1[i] != li2[i]:
            A = li1[i]
            break
        elif i == len(li2)-1:
            A = li1[-1]
    for i in range(len(li3)):
        if li2[i] != li3[i]:
            B = li2[i]
            break
        elif i == len(li3)-1:
            B = li2[-1]
    print(A)
    print(B)
n = input()
li1 = list(map(int, input().split()))
li2 = list(map(int, input().split()))
li3 = list(map(int, input().split()))
A_and_B_and_Compilation_Errors(li1, li2, li3)