#include <bits/stdc++.h>
using namespace std;
int mem[200];
int cnt = 1;
int T, N;
int all(int x) {
  for (int i = 1; i + x - 1 <= N; ++i) {
    bool f = 1;
    for (int j = i; j - i + 1 <= x; ++j)
      if (mem[j] != 0) f = 0;
    if (f) {
      for (int j = i; j - i + 1 <= x; ++j) mem[j] = cnt;
      return cnt++;
    }
  }
  return -1;
}
string era(int x) {
  bool f = 0;
  for (int i = 1; i <= N; ++i)
    if (mem[i] == x) {
      f = 1;
      mem[i] = 0;
    }
  if (f && x != 0) return "";
  return "ILLEGAL_ERASE_ARGUMENT\n";
}
void def() {
  int m2[200], p = 1;
  for (int i = 1; i <= N; ++i) {
    if (mem[i] != 0) m2[p++] = mem[i];
    mem[i] = 0;
  }
  for (int i = 1; i < p; ++i) mem[i] = m2[i];
}
int main() {
  cin >> T >> N;
  while (T--) {
    string opt;
    int x;
    cin >> opt;
    if (opt == "alloc") {
      cin >> x;
      int ret = all(x);
      if (ret == -1)
        puts("NULL");
      else
        cout << ret << '\n';
    } else if (opt == "erase") {
      cin >> x;
      cout << era(x);
    } else if (opt == "defragment")
      def();
  }
  return 0;
}
