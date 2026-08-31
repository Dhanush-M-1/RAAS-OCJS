#include <bits/stdc++.h>
using namespace std;
int t, m, n;
int mem[105];
int cur = 1;
void Alloc(int n) {
  for (int i = 0; i + n <= m; i++) {
    int j;
    for (j = 0; j < n; j++)
      if (mem[i + j]) break;
    if (j < n) continue;
    for (j = 0; j < n; j++) mem[i + j] = cur;
    cout << cur++ << endl;
    return;
  }
  cout << "NULL" << endl;
}
void Erase(int n) {
  if (n <= 0 || n >= cur)
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
  else {
    bool was = false;
    for (int i = 0; i < m; i++)
      if (mem[i] == n) {
        was = true;
        mem[i] = 0;
      }
    if (!was) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
  }
}
void Defragment() {
  for (int i = 0; i < m; i++)
    if (mem[i]) {
      int j = 0;
      while (mem[j] && j < i) j++;
      if (j < i) {
        mem[j] = mem[i];
        mem[i] = 0;
      }
    }
}
int main() {
  cin >> t >> m;
  string s;
  while (t--) {
    cin >> s;
    if (s[0] == 'a') {
      cin >> n;
      Alloc(n);
    } else if (s[0] == 'e') {
      cin >> n;
      Erase(n);
    } else
      Defragment();
  }
  return 0;
}
