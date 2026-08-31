def main():
    t = int(input())
    for i in range(t):
        n, m = map(int, input().split())
        line = input()
        ln = list(map(int, line.split()))
        line = input()
        lm = list(map(int, line.split()))
        flag = 0
        for j in range(n):
            if ln[j] in lm:
                print("YES")
                print(1,ln[j])
                flag = 1
                break
        if flag==0:
            print("NO")
        # li = []
        # for j in range(m):
        #     a, b = map(int, input().split())
        #     li.append([a, b])
        # l1 = sorted(li, key=lambda x: x[0], reverse=1)
        # l2 = sorted(li, key=lambda x: x[1], reverse=1)
        # print(l1)
        # print(l2)
        # if i < t-1:
        #     aaaa = input()

if __name__ == '__main__':
    main()