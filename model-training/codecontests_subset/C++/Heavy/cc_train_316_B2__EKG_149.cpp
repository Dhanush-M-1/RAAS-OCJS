#include <bits/stdc++.h>
using namespace std;
bool table[1010];
int mae[1010], ato[1010];
int n, x;
void init() {}
void input() {
  for (int i = (0); i < (1010); i++) table[i] = false;
  table[0] = true;
  cin >> n >> x;
  for (int i = (0); i < (1010); i++) mae[i] = ato[i] = 0;
  for (int i = (0); i < (n); i++) cin >> mae[i + 1];
  for (int i = (1); i < (n + 1); i++) ato[mae[i]] = i;
}
void solve() {
  vector<int> re;
  int mae_me;
  for (int i = (1); i < (n + 1); i++)
    if (mae[i] == 0) {
      bool me = false;
      int cnt = 0;
      int ptr = i;
      while (1) {
        if (ptr == x) {
          me = true;
          mae_me = cnt;
          break;
        }
        cnt++;
        if (ato[ptr] == 0) break;
        ptr = ato[ptr];
      }
      if (!me) re.push_back(cnt);
    }
  for (int i = (0); i < (((int)re.size())); i++) {
    int tmp[1010];
    for (int j = (0); j < (1010); j++) tmp[j] = table[j];
    for (int j = (0); j < (1010); j++)
      if (table[j]) tmp[j + re[i]] = true;
    for (int j = (0); j < (1010); j++) table[j] = tmp[j];
  }
  for (int i = (0); i < (1010); i++)
    if (table[i]) cout << i + mae_me + 1 << endl;
}
int main() {
  init();
  input();
  solve();
  return 0;
}
