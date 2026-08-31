def main():
    n = int(input())
    s = input()
    if '8' not in s:
        return 0
    q = s.count('8')
    return min(q, n//11)

if __name__=="__main__":
    print(main())