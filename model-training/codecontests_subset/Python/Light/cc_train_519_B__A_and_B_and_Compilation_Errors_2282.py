from collections import Counter

n=int(input())
main=[int(a) for a in  input().split()]
first=[int(b) for b in input().split()]
second=[int(c) for c in input().split()]

main_and_first = list((Counter(main) - Counter(first)).elements())      

first_and_second = list((Counter(first) - Counter(second)).elements())

print(main_and_first[0])

print(first_and_second[0])