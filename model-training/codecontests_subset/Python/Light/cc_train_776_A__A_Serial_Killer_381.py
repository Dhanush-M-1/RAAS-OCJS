nomes = input().split()
print(" ".join(nomes))
n = int(input())
for i in range(n):
    nl = input().split()
    nomes[nomes.index(nl[0])] = nl[1]
    print(" ".join(nomes))
