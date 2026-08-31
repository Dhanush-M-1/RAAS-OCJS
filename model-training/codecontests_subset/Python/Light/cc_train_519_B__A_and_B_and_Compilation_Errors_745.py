n = int(input())
mistakes = [int(i) for i in input().split()]
mistakes1 = [int(i) for i in input().split()]
mistakes2 = [int(i) for i in input().split()]
print(sum(mistakes)-sum(mistakes1))
print(sum(mistakes1)-sum(mistakes2))