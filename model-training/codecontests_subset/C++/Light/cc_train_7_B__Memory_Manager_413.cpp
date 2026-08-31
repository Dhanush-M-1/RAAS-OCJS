#include <bits/stdc++.h>
using namespace std;
long long m, t, M[110];
long long id = 1;
void alc(long long n) {
  for (long long i = 1; i <= m - n + 1; i++) {
    long long j;
    for (j = i; j < i + n; j++)
      if (M[j]) break;
    if (j < i + n) continue;
    for (j = i; j < i + n; j++) M[j] = id;
    cout << id++ << '\n';
    return;
  }
  cout << "NULL\n";
}
void ers(long long n) {
  long long cnt = 0;
  for (long long i = 1; i <= 100; i++)
    if (M[i] == n && M[i] >= 1 && M[i] <= 100) M[i] = 0, cnt++;
  if (!cnt) cout << "ILLEGAL_ERASE_ARGUMENT\n";
}
void frg() {
  vector<long long> v;
  for (long long i = 1; i <= 100; i++)
    if (M[i]) v.push_back(M[i]);
  memset(M, 0, sizeof(M));
  long long L = v.size();
  for (long long i = 1; i <= L; i++) M[i] = v[i - 1];
}
int main() {
  cin >> t >> m;
  while (t--) {
    string s;
    cin >> s;
    if (s == "alloc") {
      long long x;
      cin >> x;
      alc(x);
    }
    if (s == "erase") {
      long long x;
      cin >> x;
      ers(x);
    }
    if (s == "defragment") {
      frg();
    }
  }
  return 0;
}
