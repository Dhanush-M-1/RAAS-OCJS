x1,x2 = map(int,input().split())
answer = x1
while x1 // x2 > 0:
    notlighted = x1 % x2
    answer += x1//x2
    x1 = x1//x2 + notlighted
print(answer)