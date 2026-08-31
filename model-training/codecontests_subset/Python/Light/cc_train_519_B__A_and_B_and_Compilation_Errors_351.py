n = int(input())
A = list(map(int,input().split()))
B = list(map(int,input().split()))
C = list(map(int,input().split()))
a = sum(A) - sum(B)
b = sum(B) - sum(C)
print(a,b)

