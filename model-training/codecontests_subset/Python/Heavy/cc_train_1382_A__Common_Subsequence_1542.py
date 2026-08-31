import sys
inputlist=sys.stdin.readlines()
number_of_testcases=int(inputlist[0])
for i in range(number_of_testcases):
    n,m=list(map(int,inputlist[3*i+1].strip().split(' ')))
    #print(n,m)
    firstlist=list(map(int,inputlist[3*i+2].strip().split(' ')))
    secondlist=list(map(int,inputlist[3*i+3].strip().split(' ')))
    #print(firstlist)
    #print(secondlist)
    for j in firstlist:
        if j in secondlist:
            print('YES')
            print('1',j)
            break
    else:
        print('NO')