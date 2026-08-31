n = int(input())
li1 = [int(x) for x in input().split()]
li2 = [int(x) for x in input().split()]
li3 = [int(x) for x in input().split()]
error1 = sum(li1) - sum(li2)
error2 = sum(li2) - sum(li3)
print(error1)
print(error2)