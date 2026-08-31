#include <bits/stdc++.h>
using namespace std;
const int N = 100005, M = 1000000007, BIG = 0x3f3f3f3f;
int ct = 0;
int n;
int a[N];
bool Read() {
  cin >> n;
  if (cin.eof()) return 0;
  for (int i = 0; i < n; i++) cin >> a[i];
  return 1;
}
void Process() {
  int ans = 0;
  for (int i = 0; i < n; i++)
    ans = max(ans, min(abs(a[i] - 1), abs(a[i] - 1000000)));
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  while (Read()) Process();
  return 0;
}
