#include <bits/stdc++.h>
using namespace std;
int N, a[200001], cnt[200001], x, tot, ans, pos[200001 * 2], tmp[200001];
int get() {
  int x = 0;
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x;
}
void upd1(int y) {
  for (int i = -N; i <= N; i++) pos[i + N] = -1;
  pos[N] = 0;
  int sum = 0;
  for (int i = 1; i <= N; i++)
    sum += a[i] == x   ? 1
           : a[i] == y ? -1
                       : 0,
        pos[sum + N] != -1 ? ans = max(ans, i - pos[sum + N])
                           : pos[sum + N] = i;
}
void upd2(int x) {
  int l = 1, cnt = 0;
  for (int i = 1; i <= N; i++) tmp[i] = 0;
  for (int i = 1; i <= N; i++) {
    tmp[a[i]]++;
    cnt += tmp[a[i]] == x;
    while (l <= i && tmp[a[i]] > x) cnt -= tmp[a[l]] == x, tmp[a[l++]]--;
    if (cnt >= 2) ans = max(ans, i - l + 1);
  }
}
int main() {
  N = get();
  for (int i = 1; i <= N; i++) cnt[a[i] = get()]++;
  for (int i = 1; i <= N; i++)
    cnt[i] > cnt[x] ? x = i, tot = 1 : cnt[i] == cnt[x] ? tot++ : 0;
  if (tot >= 2) {
    cout << N << endl;
    return 0;
  }
  for (int i = 1; i <= N; i++)
    if (i != x && 1ll * cnt[i] * cnt[i] > N) upd1(i);
  for (int i = 1; i * i <= N; i++) upd2(i);
  cout << ans << endl;
  return 0;
}
