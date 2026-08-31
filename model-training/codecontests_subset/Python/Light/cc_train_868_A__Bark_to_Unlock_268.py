
def main():
    pw = input()
    n = int(input())
    flag = [False] * 3
    for i in range(n):
        bk = input()
        if bk == pw:
            flag[0] = True
        if bk[1] == pw[0]:
            flag[1] = True
        if bk[0] == pw[1]:
            flag[2] = True
    if flag[0] or (flag[1] and flag[2]):
        print("YES")
    else:
        print("NO")

if __name__ == '__main__':
    main()
