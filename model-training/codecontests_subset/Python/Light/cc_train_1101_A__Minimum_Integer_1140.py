def func():
    q = int(input())
    while q:
        l , r , d = map(int , input().split())
        if d>=l and d<=r:
            k = r//d
            ans = d*(k+1)
        else:
            ans = d
        print(ans)
        q-=1
if __name__ == '__main__':
    func()

