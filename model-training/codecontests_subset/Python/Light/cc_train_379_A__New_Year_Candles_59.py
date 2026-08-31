a,b = [int(x) for x in input().split()]
answer = last = a
while last >= b:
    answer += last//b
    last = last//b + last%b
print (answer)