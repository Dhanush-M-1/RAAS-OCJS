from collections import Counter

def diff(first, second):
        return list((Counter(first) - Counter(second)).elements()) 

if __name__ == "__main__":
    t=int(input())
    l1 = [int(v) for v in input().split()]
    l2 = [int(v) for v in input().split()]
    l3 = [int(v) for v in input().split()]
    for i in diff(l1,l2):
        print(i)
    for i in diff(l2,l3):
        print(i)
    