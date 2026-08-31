kol = int(input())
a = input()
variants = []
bilo = False
for i in range(0, kol-1):
    for var in variants:
        if a[i:i+2] == var[0]:
            bilo = True
            var[1] += 1
            break
    if not bilo:
        variants.append([str(a[i:i+2]), 1])
    bilo = False
n = 1
while n < len(variants):
     for i in range(len(variants)-n):
          if variants[i][1] > variants[i+1][1]:
               variants[i],variants[i+1] = variants[i+1],variants[i]
     n += 1
print(variants[-1][0])
