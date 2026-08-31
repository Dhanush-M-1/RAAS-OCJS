n = int(input())
str = input()
res = 0

much = str.count("8")

while n >= 11:
    if much > 0:
        n -= 11
        much -= 1
        res += 1
    else:
        break
        
print(res)