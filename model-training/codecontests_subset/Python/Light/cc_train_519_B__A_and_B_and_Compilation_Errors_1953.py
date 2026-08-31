'''
Codeforces: 519B. A and B and Compilation Errors
'''
import collections
n = input()
erros = input().split()
counter = collections.Counter(erros)
first_time = collections.Counter(input().split())
second_time = collections.Counter(input().split())
first = None
second = None
for erro in erros:
    if first != None and second != None:
        break
    if counter[erro] != first_time[erro]:
        first = erro
    if first_time[erro] != second_time[erro]:
        second = erro

print(first)
print(second)

