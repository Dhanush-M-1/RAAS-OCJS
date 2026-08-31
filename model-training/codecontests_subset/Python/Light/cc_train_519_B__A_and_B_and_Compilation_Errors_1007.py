n = int(input())

s = [int(x) for x in input().split()]
then = [int(x) for x in input().split()]
final= [int(x) for x in input().split()]

print(sum(s)-sum(then))
print(sum(then)-sum(final))