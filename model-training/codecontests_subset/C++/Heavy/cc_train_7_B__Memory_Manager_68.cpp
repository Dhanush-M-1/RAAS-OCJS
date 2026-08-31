#include <bits/stdc++.h>
namespace fastIO {
template <typename T>
inline T read() {
  T f = 1, x = 0;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = x * 10 + c - '0';
    c = getchar();
  }
  return x * f;
}
template <typename T>
inline void write(T x) {
  if (!x) {
    putchar('0');
    return;
  }
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
}  // namespace fastIO
using namespace std;
using fastIO ::write;
namespace fastOutput {
inline void print_array1(int *a, int n) {
  for (int(i) = (1); (i) <= (n); ++(i)) write(a[i]), putchar(" \n"[i == n]);
}
inline void print_array2(int *a, int n) {
  write(n), puts("");
  print_array1(a, n);
}
inline void special_print_array1(int *a, int n) {
  write(n), putchar(' ');
  print_array1(a, n);
}
inline void print_string_in_range(string s, int l, int r) {
  for (int(i) = (l); (i) <= (r); ++(i)) putchar(s[i]);
}
inline void print_chars_in_range(char *a, int l, int r) {
  for (int(i) = (l); (i) <= (r); ++(i)) putchar(a[i]);
}
}  // namespace fastOutput
using fastOutput ::print_array1;
using fastOutput ::print_array2;
using fastOutput ::print_chars_in_range;
using fastOutput ::print_string_in_range;
using fastOutput ::special_print_array1;
int t, m, cnt, l[107], r[107], vis[107], in[107];
string opt;
namespace MemoryManager {
inline void alloc(int x) {
  for (int(i) = (1); (i) <= (m - x + 1); ++(i)) {
    int flag = 1;
    for (int(j) = (i); (j) <= (i + x - 1); ++(j))
      if (vis[j]) flag = 0;
    if (flag) {
      write(++cnt), puts("");
      l[cnt] = i, r[cnt] = i + x - 1;
      for (int(j) = (l[cnt]); (j) <= (r[cnt]); ++(j)) vis[j] = 1;
      in[cnt] = 1;
      return;
    }
  }
  return puts("NULL"), void();
}
inline void erase(int x) {
  if (x < 1 || x > cnt || !in[x]) return puts("ILLEGAL_ERASE_ARGUMENT"), void();
  for (int(i) = (l[x]); (i) <= (r[x]); ++(i)) vis[i] = 0;
  l[x] = r[x] = in[x] = 0;
}
inline void defragment() {
  for (int(i) = (1); (i) <= (cnt); ++(i))
    if (in[i]) {
      for (int(j) = (l[i]); (j) <= (r[i]); ++(j)) vis[j] = 0;
      while (l[i] > 1 && !vis[l[i] - 1]) l[i]--, r[i]--;
      for (int(j) = (l[i]); (j) <= (r[i]); ++(j)) vis[j] = 1;
    }
}
}  // namespace MemoryManager
using namespace MemoryManager;
int main() {
  t = fastIO ::read<int>(), m = fastIO ::read<int>();
  while (t--) {
    cin >> opt;
    if (opt == "alloc")
      alloc(fastIO ::read<int>());
    else if (opt == "erase")
      erase(fastIO ::read<int>());
    else
      defragment();
  }
  return 0;
}
