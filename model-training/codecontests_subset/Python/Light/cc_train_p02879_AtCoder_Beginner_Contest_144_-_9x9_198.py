A, B = map(int, input().split())

ans = A*B if max(A,B)<=9 else -1

print(ans)