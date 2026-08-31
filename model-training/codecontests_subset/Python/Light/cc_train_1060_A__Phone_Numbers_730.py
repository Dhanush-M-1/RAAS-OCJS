n = int(input())
s = input()
r = s.count('8')
s.replace('8', '')
sub = len(s) // 11
print(min(sub, r))