dat = [0] * 10
n = int(input())
s = input()
num8 = s.count("8")
print(min(num8, n // 11))