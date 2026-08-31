def choosing(evens,odds,even):
    e,o=0,0
    total = sum(evens)+sum(odds)
    while True:
        if even and e<len(evens):
            total-=evens[e]
            e+=1
            even=not even
        elif not even and o<len(odds):
            total-=odds[o]
            o+=1
            even=not even
        else:
            break
    return total


def solution(arr):
    evens = []
    odds = []

    for a in arr:
        if a%2==0:
            evens.append(a)
        else:
            odds.append(a)

    evens.sort(reverse=True)
    odds.sort(reverse=True)

    return min(choosing(evens,odds,even=True),choosing(evens,odds,even=False))


n = int(input())
arr = [int(i) for i in input().split()]
print(solution(arr))
