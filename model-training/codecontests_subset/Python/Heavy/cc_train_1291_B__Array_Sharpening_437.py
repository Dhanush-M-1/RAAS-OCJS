from sys import stdin, stdout

def main():
    T = int(stdin.readline())
    for zzz in range(T):
        n = int(stdin.readline())
        arr = list(map(int, stdin.readline().split()))
        fail = False
        for i,x in enumerate(arr):
            
            if i < int(n/2) and x < i:
                stdout.write("No\n")
                fail = True
                break
            if i >= int(n/2) and x < n - i - 1:
                stdout.write("No\n")
                fail = True
                break
        if fail is True:
            continue
        if n % 2 == 0 and arr[int(n/2) -1] == int(n/2) -1 and arr[int(n/2)] == int(n/2) - 1:
            stdout.write("No\n")
            continue
        stdout.write("Yes\n")
                
                
        
                

main()