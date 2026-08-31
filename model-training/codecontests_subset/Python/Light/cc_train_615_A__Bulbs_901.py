def main():
    """Main Method."""
    n, m = map(int, input().split())
    
    bulbs = [0] * m
    
    for _ in range(n):
        l = [int(x) for x in input().split()]
        yi = l[1:]
        for y in yi:
            bulbs[y-1] += 1    

    for x in bulbs:
        if x == 0:
            print("NO")
            return

    print("YES")
    return

if __name__ == "__main__":
    main()