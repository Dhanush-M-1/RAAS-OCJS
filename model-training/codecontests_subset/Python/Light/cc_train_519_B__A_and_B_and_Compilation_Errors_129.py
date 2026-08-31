r=input()
A,B,C=list(map(int,input().split())),list(map(int,input().split())),list(map(int,input().split()))
print("{}\n{}".format(sum(A)-sum(B),sum(B)-sum(C)))