#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
int ddx[] = {1, 0};
int ddy[] = {1, 1};
int n;
string vec[1500];
string s, ans;
int alf[1500];
int main() {
  cin >> n;
  cin >> s;
  if (n == 1) {
    cout << s << endl;
    return 0;
  }
  for (int i = 0; i < int(s.size()); i++) {
    alf[s[i]]++;
  }
  int aux = 0;
  for (int i = 0; i < 1500; i++) {
    if (alf[i] != 0 and aux == 0) aux = alf[i];
    if (alf[i] != 0 and alf[i] % n != 0) {
      cout << -1 << endl;
      return 0;
    }
  }
  for (int i = 0; i < 1500; i++) {
    if (alf[i] != 0)
      for (int j = 0; j < alf[i] / n; j++) ans += (char)i;
  }
  for (int i = 0; i < n; i++) cout << ans;
  cout << endl;
  return 0;
}
