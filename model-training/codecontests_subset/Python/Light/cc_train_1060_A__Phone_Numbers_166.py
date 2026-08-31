_ = input()
N = input()
Num = N.count('8')
div = len(N) // 11
print(min(Num, div))