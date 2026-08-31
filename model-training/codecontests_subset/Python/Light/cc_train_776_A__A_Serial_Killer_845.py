def main():
    pv1, pv2 = input().split()
    days = int(input())
    
    print(pv1, pv2)
    for i in range(days):
        c, d = input().split()
        if pv1 == c:
            pv1 = d
        elif pv2 == c:
            pv2 = d
        print(pv1, pv2)


main()

