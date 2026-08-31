errors_n = int(input())

compilations = [tuple(map(int,input().split())) for i in range(3)]

[print(sum(a)-sum(b)) for a,b in list(zip(compilations,compilations[1:]))]