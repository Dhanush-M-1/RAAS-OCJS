def main():
    p = input()
    n = int(input())
    words = []
    for i in range(n):
        words.append(input())
    if any(w[0]==p[0] and w[1] ==p[1] for w in words):
        print("YES")
    elif any(w[1] == p[0] for w in words) and any(w[0] == p[1] for w in words):
            print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()
