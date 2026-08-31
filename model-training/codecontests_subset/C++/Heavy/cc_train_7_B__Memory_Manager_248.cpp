#include <bits/stdc++.h>
using namespace std;
int t, n, m, id = 0, num[105], exist = 0, vs[105];
bool del[105];
long long x;
string datain;
void alloc() {
  cin >> n;
  num[id] = n;
  exist++;
  bool ok;
  for (int i = 1; i <= m - n + 1; i++) {
    ok = true;
    for (int j = i; j <= i + n - 1; j++)
      if (vs[j] != 0) {
        ok = false;
        break;
      }
    if (ok) {
      id++;
      for (int j = i; j <= i + n - 1; j++) vs[j] = id;
      cout << id << endl;
      return;
    }
  }
  cout << "NULL" << endl;
}
void erase() {
  cin >> x;
  if (x <= 0 || x > id || x > exist || del[x]) {
    cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    return;
  }
  for (int i = 1; i <= m; i++)
    if (vs[i] == x) vs[i] = 0;
  del[x] = true;
}
void defragment() {
  vector<int> save;
  for (int i = 1; i <= m; i++)
    if (vs[i]) save.push_back(vs[i]);
  for (int i = 1; i <= m; i++)
    if (i < save.size() + 1)
      vs[i] = save[i - 1];
    else
      vs[i] = 0;
}
int main() {
  cin >> t >> m;
  memset(del, false, sizeof(del));
  while (t--) {
    cin >> datain;
    if (datain[0] == 'a') alloc();
    if (datain[0] == 'e') erase();
    if (datain[0] == 'd') defragment();
  }
}
