from collections import deque, defaultdict
for _ in range(int(input())):
    n = int(input())
    mat = [[]]
    for i in range(n):
        a = [0]+list(input().strip())
        mat.append(a)
    one = [mat[1][2], mat[2][1]]
    two = [mat[n][n-1], mat[n-1][n]]
    if len(set(one+two))==1:
        print(2)
        print(n,n-1)
        print(n-1,n)
    elif len(set(one))==1 and len(set(two))==1 and set(one)!=set(two):
        print(0)
    else:
        if one[0]==one[1]:
            if one[0]==two[0]:
                print(1)
                print(n,n-1)
            else:
                print(1)
                print(n-1,n)
        elif two[0]==two[1]:
            if two[0] == one[0]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
        else:
            print(2)
            if one[0]=="1":
                print(2,1)
            else:
                print(1,2)
            if two[0]=="0":
                print(n-1,n)
            else:
                print(n,n-1)