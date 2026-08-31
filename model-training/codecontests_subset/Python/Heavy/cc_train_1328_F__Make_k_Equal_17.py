def move(n, k, heights):
    heights.sort()
    
    for i in range(n-k+1):
        if heights[i] == heights[i+k-1]:
            return 0
    
    m = heights[n - 1 >> 1]
    a = sum(heights[k-1] - heights[i] for i in range(k)) - sum(heights[i] == heights[k-1] for i in range(k, n))
    b = sum(heights[n-1-i] - heights[n-k] for i in range(k)) - sum(heights[n-i-1] == heights[n-k] for i in range(k, n))
    c = sum(abs(m - heights[i]) for i in range(n)) - (n - k)
      
    return min(a, b, c)

n, k = map(int, input().split())
heights = list(map(int, input().split()))
print(move(n, k, heights))
