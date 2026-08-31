def change_uniform(colors):
    result = 0
    for v in colors.values():
        result += v[0] * v[1]
    return result
 
if __name__ == "__main__":
    n = int(input())
    colors = dict()  # hash of colors each is pair of (host, guest) clubes count that are wearing it
    for i in range(n):
        color_h, color_g = input().split()
        for i, color in enumerate((color_h, color_g)):
            colors.setdefault(color, [0,0])[i] += 1
    
    result = change_uniform(colors)
    print(result)