#include <bits/stdc++.h>
using namespace std;
const int INF = 2 * ((1 << 30) - 1) + 1;
inline int gcd(int a, int b) { return b ? gcd(b, a % b) : a; }
inline int ceil(int a, int b) { return (a + b - 1) / b; }
typedef struct {
  int type;
  int a;
  int b;
  int x;
} Step;
int main(void) {
  int n, m;
  cin >> n >> m;
  int diff[n], max_a[n];
  bool det[n];
  memset(diff, 0, sizeof(diff));
  memset(max_a, 0, sizeof(max_a));
  memset(det, false, sizeof(det));
  vector<Step> v;
  for (int i = 0; i < m; i++) {
    int type, a, b, x;
    cin >> type >> a >> b >> x;
    --a;
    --b;
    if (type == 1) {
      for (int j = a; j <= b; j++) diff[j] += x;
    } else {
      for (int j = a; j <= b; j++) {
        max_a[j] = det[j] ? min(max_a[j], x - diff[j]) : x - diff[j];
        det[j] = true;
      }
    }
    Step s = {type, a, b, x};
    v.push_back(s);
  }
  vector<int> arr(max_a, max_a + n);
  for (int i = 0; i < m; i++) {
    Step s = v[i];
    if (s.type == 1) {
      for (int j = s.a; j <= s.b; j++) arr[j] += s.x;
    } else {
      int mx = arr[s.a];
      for (int j = s.a + 1; j <= s.b; j++) mx = max(mx, arr[j]);
      if (mx != s.x) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) cout << max_a[i] << " ";
  cout << "\n";
  return 0;
}
