MOD = 10 ** 9 + 7
INF = 10 ** 10
import sys
sys.setrecursionlimit(100000000)
dy = (-1,0,1,0)
dx = (0,1,0,-1)

def main():
    q = int(input())
    power10 = [1]
    for i in range(7):
        power10.append(10*power10[-1])

    for _ in range(q):
        N = int(input())
        if N//10 == 0:
            print(0)
            continue

        visited = {N}
        cnt = 0
        while True:
            cnt += 1
            next_number = -1
            for i in range(1,len(str(N))):
                next_number = max(next_number,(N//power10[i])*(N%power10[i]))
            if next_number in visited:
                cnt = -1
                break
            if next_number//10 == 0:
                break
            else:
                visited.add(next_number)
                N = next_number

        print(cnt)        
if __name__ == '__main__':
    main()
