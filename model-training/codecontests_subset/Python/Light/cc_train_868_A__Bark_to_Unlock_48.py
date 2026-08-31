def main():
    p = input()
    l = [input() for i in range(int(input()))]
    for i in range(len(l)):
        for j in range(len(l)):
            c = l[i] + l[j]
            if p in c:
                return print("YES")
    print("NO")
main()
