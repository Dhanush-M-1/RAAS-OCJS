#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
long long t, n, p[105], cnt;
void debug() {
  for (long long i = 1; i <= n; i++) cout << p[i] << " ";
  cout << endl;
}
long long alloc(long long len) {
  for (long long i = 1; i <= n - len + 1; i++) {
    long long pd = 1;
    for (long long j = 0; j < len; j++)
      if (p[i + j] != inf) pd = 0;
    if (pd) {
      cnt++;
      for (long long j = 0; j < len; j++) p[i + j] = cnt;
      return cnt;
    }
  }
  return -1;
}
long long erase(long long id) {
  long long pd = 0;
  for (long long i = 1; i <= n; i++)
    if (p[i] == id) pd = 1, p[i] = 0;
  if (pd) return id;
  return -1;
}
void defrag() {
  long long k[105], pos = 1;
  memset(k, 0, sizeof(k));
  for (long long i = 1; pos <= n; i++)
    while (pos <= n) {
      if (p[pos] != inf) {
        k[i] = p[pos++];
        break;
      } else
        pos++;
    }
  for (long long i = 1; i <= n; i++) p[i] = k[i];
}
void update() {
  for (long long i = 1; i <= n; i++)
    if (p[i] == 0) p[i] = inf;
}
signed main() {
  cin >> t >> n;
  for (long long i = 1; i <= t; i++) {
    update();
    string s;
    long long id;
    cin >> s;
    if (s[0] == 'd')
      defrag();
    else {
      cin >> id;
      if (s[0] == 'e') {
        if (erase(id) == -1) cout << "ILLEGAL_ERASE_ARGUMENT\n";
      } else if (s[0] == 'a') {
        long long get = alloc(id);
        if (get == -1)
          cout << "NULL\n";
        else
          cout << get << endl;
      }
    }
  }
  return 0;
}
