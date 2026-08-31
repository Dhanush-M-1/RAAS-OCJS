def main():
    a,b = map(int,input().split())
    term =a//b
    rem=a%b
    hours=a + term
    collect=[hours]
    term+=rem
    while (term>=b):
        rem=term%b
        term=term//b
        collect.append(term)
        term+=rem
    print(sum(collect))

if __name__ == "__main__":
    main()
