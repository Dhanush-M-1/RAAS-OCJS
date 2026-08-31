
def solve(s, arr):
    arr.sort()
    ans = 0
    i = len(arr) // 2

    if arr[i] < s:
        ans += s - arr[i]
        i += 1
        while i < len(arr) and arr[i] < s:
            ans += s - arr[i]
            i += 1
    else:
        ans += arr[i] - s
        i -= 1
        while i > -1 and arr[i] > s:
            ans += arr[i] - s
            i -= 1
            
    return ans;

# Main
def main():
    n, s = map(int, input().split())
    arr = list(map(int, input().split()))

    print(solve(s, arr))
#end main

#Program Start
if __name__ == "__main__":
    main()

