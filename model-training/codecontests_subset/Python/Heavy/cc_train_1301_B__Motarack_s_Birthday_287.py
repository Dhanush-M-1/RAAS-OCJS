from math import floor,ceil
t = int(input())
for _ in range(0,t):
    n = int(input())
    aa = [int(i) for i in input().split()]
    problem = []
    already = []
    for i in range(0,n-1):
        if aa[i] == -1 and aa[i+1] != -1:
            problem.append(aa[i+1])
        elif aa[i] != -1 and aa[i+1] == -1:
            problem.append(aa[i])
        elif aa[i] != -1 and aa[i+1] != -1:
            already.append(abs(aa[i]-aa[i+1]))
    if len(problem) == 0:
        print(0,0)
    else:
        problem.sort()
        k = (problem[-1]+problem[0])//2
        also = -1
        original = max(problem[-1]-k,k-problem[0])
        if len(already):
            also = max(already)
        if also != -1:
            if original <= also:
                print(also,k)
            else:
                print(original,k)
        else:
            print(original,k)




