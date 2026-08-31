def main():
    """Main Method."""
    n, m = map(int, input().split())
    
    s = set()
    
    for _ in range(n):
        l = [int(x) for x in input().split()]
        yi = l[1:]
        s = s.union(yi)

    if(len(s) == m):
        print("YES")
    
    else:
        print("NO")
    


if __name__ == "__main__":
    main()