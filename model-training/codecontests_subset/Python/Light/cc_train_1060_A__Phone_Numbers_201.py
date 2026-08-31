n = int(input())
numbers = input()
eights = numbers.count('8')
print(min(eights, n // 11))
