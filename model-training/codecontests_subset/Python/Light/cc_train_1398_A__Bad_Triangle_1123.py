t = int(input())
#for each test cases
for i in range(t):
    n=int(input())
    q=list(map(int,input().split()))
    if (q[0]+q[1]<=q[len(q)-1]):
        print("1 2 "+str(len(q)))
    else:
        print("-1")