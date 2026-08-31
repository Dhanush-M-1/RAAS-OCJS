import sys
sys_input = sys.stdin.readline

def inp():
    return int(sys_input())
def minp():
    return map(int,sys_input().split())
def linp():
    return list(map(int,sys_input().split()))
def inpsl():
    return list(input().split())
def write(s):
    sys.stdout.write(s)

def main():
    m = input()
    i = 0
    vec = []
    while i< len(m):
        vec.append(m[i])
        i += 2
    vec = sorted(vec)
    for v in range(len(vec)-1):
        write(str(vec[v])+"+")
    write(vec[-1])

main()