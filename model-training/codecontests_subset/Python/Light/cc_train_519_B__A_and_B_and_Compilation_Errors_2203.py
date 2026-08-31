n = int(input())

errors = list(map(int,input().split()))[:n]
errors_one = list(map(int,input().split()))[:n-1]
errors_two = list(map(int,input().split()))[:n-2]

answer_one = sum(errors)-sum(errors_one)
answer_two = sum(errors_one)-sum(errors_two)

print(answer_one)
print(answer_two)