N = int(input())
A = list(map(int, input().split(' ')))
B = list(map(int, input().split(' ')))
C = list(map(int, input().split(' ')))

sum_A = sum(A)
sum_B = sum(B)
sum_C = sum(C)

print(sum_A - sum_B)
print(sum_B - sum_C)