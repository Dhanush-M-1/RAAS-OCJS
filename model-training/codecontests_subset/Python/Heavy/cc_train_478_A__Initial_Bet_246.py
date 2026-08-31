def gcd(a,b):
    if a == 0: return b
    return gcd(b % a, a)

def solve():
    a,b,c,d,e = map(int, input().split())
    # print(a,b,c,d,e)
    sum = a + b + c + d + e

    if sum == 0: print(-1); return

    if sum % 5 ==0:
        print(int(sum/5))
    else:
        print(-1)

solve()
    # C = [0]; ptr = 0; i = 1; begin = False
# while i < len(B):
#     if B[i] == B[ptr]:
#         ptr += 1
#         C.append(ptr)
#         i += 1
#     else:
#         # Update till prefix matched
#         if ptr != 0:
#             ptr = C[ptr-1]
#             # Also no i increment
#         else:
#             C.append(0)
#             i += 1
# print(C)
