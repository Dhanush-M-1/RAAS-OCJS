numberOfErrors = int(input())

firstErrors, secondErrors, thirdErrors = [sum(list(map(int, input().split()))) for i in range(3)]

print(firstErrors - secondErrors)

print(secondErrors - thirdErrors)