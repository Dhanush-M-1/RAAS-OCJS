def main():
    n = int(input())
    a = list(map(int, input().split()))
    odd_count, even_count = 0, 0
    odd = []
    even = []
    for x in a:
        if x % 2:
            odd.append(x)
            odd_count += 1
        else:
            even.append(x)
            even_count += 1
        
    # odd = reversed(sorted(odd))
    # even = reversed(sorted(even))

    # odd.sort()
    # even.sort()

    res = 0
    if odd_count < even_count:
        if (odd_count + 1) == even_count:
            res = 0
        else:
            temp = even_count - odd_count - 1
            even.sort()
            res = sum(even[:temp])
    
    elif odd_count > even_count:
        if (even_count + 1) == odd_count:
            res = 0
        else:
            temp = odd_count - even_count - 1
            odd.sort()
            res = sum(odd[:temp])

    else:
        res = 0
    print(res)

if __name__ == "__main__":
    main()