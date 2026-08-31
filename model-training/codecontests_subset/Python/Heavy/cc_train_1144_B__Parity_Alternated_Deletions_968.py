def main():
    n = int(input())
    array = list(map(int,input().split()))
    even = []
    odd = []
    for i in array:
        if i%2 == 0:
            even.append(i)
        else:
            odd.append(i)

    even.sort(reverse = True)
    odd.sort(reverse = True)
    even1 = even[:]
    odd1 = odd[:]
    even2 = even[:]
    odd2 = odd[:]
    k = min(len(even),len(odd))
    for i in range(k):
        even1.pop(0)
        odd1.pop(0)
    if even1:
        even1.pop(0)
    ans1 = sum(even1)+sum(odd1)
    
    for i in range(k):
        even2.pop(0)
        odd2.pop(0)
    if odd2:
        odd2.pop(0)
    ans = sum(even2)+sum(odd2)

    print(min(ans1,ans))
    
main()
