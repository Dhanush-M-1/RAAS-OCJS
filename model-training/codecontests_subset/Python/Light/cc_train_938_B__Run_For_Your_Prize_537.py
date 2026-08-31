n = int(input())
numbers = [int(i) for i in input().split()]
max_n = -1
for i in range(len(numbers)):
    if numbers[i] > 5 * (10 ** 5):
        numbers[i] = 10 ** 6 - numbers[i] + 1
    if numbers[i] > max_n:
        max_n = numbers[i]
print(max_n - 1)        
