n = int(input())

cs = input()

eights = sum(1 for c in cs if c == '8')

print(min(len(cs) // 11, eights))
