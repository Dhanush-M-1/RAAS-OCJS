A= 'a'
n = int(input())
# 二つのリストを独立に動かす.
# max('ab') は文字列のアルファベット順での最大値
for _ in range(n - 1):
    # max(a)の次のアルファベットを追加してsorted　で辞書順に
    A = [a + s for a in A for s in sorted(set(a + chr(ord(max(a))+1))) ]
print(*A, sep = '\n')