a = int(input())
n = sum([int(i) for i in (input().split())])
n_1 = sum([int(i) for i in (input().split())])
n_2 = sum([int(i) for i in (input().split())])


print(n - n_1, n_1 - n_2, sep='\n')