n = int(input())
s = input()
res = [s.count('A'), 1, 0]
print(res[min(s.count('I'), 2)])
