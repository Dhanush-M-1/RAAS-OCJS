def compilation_errors(r):
    for i in range(0,len(r)-1):
        print(sum(r[i]) - sum(r[i+1]))

if __name__ == '__main__':
    n = int(input())
    d = []
    d.append(list(map(int, input().split())))
    d.append(list(map(int, input().split())))
    d.append(list(map(int, input().split())))
    compilation_errors(d)