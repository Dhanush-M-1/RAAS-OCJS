n = int(input())
s = input()
temp = [0]*2
temp[0] = n // 11
temp[1] = s.count("8")
print(min(temp))
