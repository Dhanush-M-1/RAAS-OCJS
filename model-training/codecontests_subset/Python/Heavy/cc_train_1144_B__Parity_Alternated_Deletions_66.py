import random
def ii():
    return int(input())


def mi():
    return map(int, input().split())


def li():
    return list(mi())

def main():
    n = input()
    a = li()
    even = []
    odd = []
    for i in a:
        if i % 2 == 0:
            even.append(i)
        else:
            odd.append(i)

    even = sorted(even)
    odd = sorted(odd)
    even2 = [i for i in even]
    odd2 = [i for i in odd]
    sum1, sum2 = (0,0)
    if len(even) == len(odd):
        print(0)
        exit()
    while(len(even)>0 and len(odd)>0):
        even.pop()
        odd.pop()


    if len(odd) > 0:
        odd.pop()
        sum1 = sum(odd)
    else:
        even.pop()
        sum1 = sum(even)

    while (len(even2) > 0 and len(odd2) > 0):
        even2.pop()
        odd2.pop()

    if len(odd2) > 0:
        odd2.pop()
        sum2 = sum(odd2)
    else:
        even2.pop()
        sum2 = sum(even2)

    print (max(sum1,sum2))





main()




