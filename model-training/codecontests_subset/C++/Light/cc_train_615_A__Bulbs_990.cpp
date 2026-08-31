#include <bits/stdc++.h>
using namespace std;
vector<long long int> v;
vector<long long int> v1;
vector<long long int> v2;
const int inf = 100000005;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int hs[105];
  memset(hs, 0, sizeof(hs));
  int n, m;
  cin >> n >> m;
  int a, b;
  for (int i = 0; i < n; i++) {
    cin >> a;
    for (int j = 0; j < a; j++) {
      cin >> b;
      hs[b] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (hs[i] == 0) {
      cout << "NO" << endl;
      return 0;
    }
  cout << "YES" << endl;
  return 0;
}
