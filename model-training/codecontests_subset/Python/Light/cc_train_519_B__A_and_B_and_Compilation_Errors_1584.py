n= int(input())
line1 = sum([int(i) for i in input().split()])
line2 = sum([int(i) for i in input().split()])
line3 = sum([int(i) for i in input().split()])
first = line1-line2
second = line2-line3
print(first)
print(second)
