def main():
    n,m = [int(v) for v in input().split()]
    added = set([i for i in range(1, m+1)])
    for i in range(n):
        c, *l = [int(v) for v in input().split()]
        for ll in l:
            if ll in added:
                added.remove(ll)
    print('YES' if len(added)==0 else "NO")



if __name__ == "__main__":
    main()
